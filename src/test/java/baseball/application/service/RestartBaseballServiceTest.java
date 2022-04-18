package baseball.application.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.application.port.in.RestartBaseballCommand;
import baseball.application.port.in.RestartBaseballUsecase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class RestartBaseballServiceTest {

    @Test
    void 종료_테스트() {
        RestartBaseballUsecase restartBaseballUsecase = new RestartBaseballService();
        assertTrue(restartBaseballUsecase.isFinished(new RestartBaseballCommand("2")));

    }

    @Test
    void 다시시작_테스트() {
        RestartBaseballUsecase restartBaseballUsecase = new RestartBaseballService();
        assertFalse(restartBaseballUsecase.isFinished(new RestartBaseballCommand("1")));
    }

}