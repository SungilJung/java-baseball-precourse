package baseball.application.service;

import baseball.application.port.in.PlayInningCommand;
import baseball.application.port.in.PlayInningUsecase;
import baseball.application.port.out.GetAiPitchesPort;
import baseball.domain.Pitches;
import baseball.domain.PitchingResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayInningService implements PlayInningUsecase {

    private final GetAiPitchesPort getAiPitchesPort;

    @Override
    public PitchingResult playInning(PlayInningCommand command) {
        Pitches playerPitches = command.getPlayerPitches();
        Pitches aiPitches = getAiPitchesPort.getAiPitches();

        return aiPitches.compareTo(playerPitches);

    }
}
