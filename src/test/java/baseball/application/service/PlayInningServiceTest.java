package baseball.application.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.application.port.in.PlayInningCommand;
import baseball.application.port.in.PlayInningUsecase;
import baseball.application.port.out.GetAiPitchesPort;
import baseball.domain.Pitch;
import baseball.domain.Pitches;
import baseball.domain.PitchingResult;
import baseball.domain.PitchingResult.Kind;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class PlayInningServiceTest {

    @Test
    void 플레이_이닝() {
        GetAiPitchesPort getAiPitchesPort = new FakeAiPitchesAdapter();

        PlayInningUsecase playInningUsecase = new PlayInningService(getAiPitchesPort);

        assertAll(() -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("456")), createResult(
                        Stream.of(new Object[][]{{Kind.NOTHING, 3},})
                                .collect(Collectors.toMap(data -> (Kind) data[0], data -> (Integer) data[1])))),
                () -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("231")), createResult(
                        Stream.of(new Object[][]{{Kind.BALL, 3},})
                                .collect(Collectors.toMap(data -> (Kind) data[0], data -> (Integer) data[1])))),
                () -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("132")), createResult(
                        Stream.of(new Object[][]{{Kind.STRIKE, 1}, {Kind.BALL, 2},})
                                .collect(Collectors.toMap(data -> (Kind) data[0], data -> (Integer) data[1])))),
                () -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("124")), createResult(
                        Stream.of(new Object[][]{{Kind.STRIKE, 2}, {Kind.NOTHING, 1},})
                                .collect(Collectors.toMap(data -> (Kind) data[0], data -> (Integer) data[1])))),
                () -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("123")), createResult(
                        Stream.of(new Object[][]{{Kind.STRIKE, 3},})
                                .collect(Collectors.toMap(data -> (Kind) data[0], data -> (Integer) data[1])))));
    }

    private PitchingResult createResult(Map<Kind, Integer> dataMap) {
        PitchingResult result = new PitchingResult();

        for (Entry<Kind, Integer> entry : dataMap.entrySet()) {
            int i = 0;

            while (i < entry.getValue()) {
                result.increase(entry.getKey());
                i++;
            }
        }
        return result;
    }

    private static class FakeAiPitchesAdapter implements GetAiPitchesPort {

        private final Pitches pitches = new Pitches();

        public FakeAiPitchesAdapter() {
            pitches.add(new Pitch(1));
            pitches.add(new Pitch(2));
            pitches.add(new Pitch(3));
        }

        @Override
        public Pitches getAiPitches() {
            return pitches;
        }
    }

}