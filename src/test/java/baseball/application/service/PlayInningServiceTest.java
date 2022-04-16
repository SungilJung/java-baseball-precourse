package baseball.application.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.application.port.in.PlayInningCommand;
import baseball.application.port.in.PlayInningUsecase;
import baseball.application.port.out.GetAiPitchesQuery;
import baseball.domain.GameResult;
import baseball.domain.Pitch;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PlayInningServiceTest {


    @Test
    void 플레이_이닝() {
        GetAiPitchesQuery getAiPitchesQuery = new FakeGetAiPitchesQuery();

        PlayInningUsecase playInningUsecase = new PlayInningService(getAiPitchesQuery);

        assertAll(() -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("456")), new GameResult(0, 0)),
                () -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("231")), new GameResult(0, 3)),
                () -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("132")), new GameResult(1, 2)),
                () -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("124")), new GameResult(2, 0)),
                () -> assertEquals(playInningUsecase.playInning(new PlayInningCommand("123")), new GameResult(3, 0)),
                () -> assertTrue(playInningUsecase.playInning(new PlayInningCommand("123")).isFinish()));
    }

    private static class FakeGetAiPitchesQuery implements GetAiPitchesQuery {

        private final Map<Pitch, Integer> aiPitches = new HashMap<>();

        public FakeGetAiPitchesQuery() {
            aiPitches.put(new Pitch(1), 0);
            aiPitches.put(new Pitch(2), 1);
            aiPitches.put(new Pitch(3), 2);
        }

        @Override
        public Map<Pitch, Integer> getAiPitches() {

            return aiPitches;
        }
    }

}