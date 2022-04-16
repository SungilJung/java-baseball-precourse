package baseball.application.service;

import baseball.application.port.in.PlayInningCommand;
import baseball.application.port.in.PlayInningUsecase;
import baseball.application.port.out.GetAiPitchesQuery;
import baseball.domain.GameResult;
import baseball.domain.Pitch;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayInningService implements PlayInningUsecase {

    private static final int NOT_FOUND = -1;

    private final GetAiPitchesQuery getAiPitchesQuery;

    private enum PitchResult {
        BALL, STRIKE, NOTHING
    }

    @Override
    public GameResult playInning(PlayInningCommand command) {
        Map<Pitch, Integer> playerPitches = command.getPlayerPitches();
        Map<Pitch, Integer> aiPitches = getAiPitchesQuery.getAiPitches();

        Map<PitchResult, Integer> resultMap = new EnumMap<>(PitchResult.class);
        resultMap.put(PitchResult.BALL, 0);
        resultMap.put(PitchResult.STRIKE, 0);

        for (Entry<Pitch, Integer> entry : aiPitches.entrySet()) {
            resultMap.computeIfPresent(getResultKind(entry, playerPitches), (key, value) -> ++value);
        }

        return new GameResult(resultMap.get(PitchResult.STRIKE), resultMap.get(PitchResult.BALL));
    }

    private PitchResult getResultKind(Entry<Pitch, Integer> src, Map<Pitch, Integer> targetMap) {
        PitchResult kind = PitchResult.NOTHING;

        int targetIndex = targetMap.getOrDefault(src.getKey(), NOT_FOUND);

        if (NOT_FOUND != targetIndex) {
            kind = (targetIndex == src.getValue()) ? PitchResult.STRIKE : PitchResult.BALL;
        }

        return kind;
    }
}
