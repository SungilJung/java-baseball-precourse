package baseball.application.service;

import baseball.application.port.in.RestartBaseballCommand;
import baseball.application.port.in.RestartBaseballUsecase;

public class RestartBaseballService implements RestartBaseballUsecase {
    private static final char FINISH_CODE = '2';

    @Override
    public boolean isFinished(RestartBaseballCommand command) {
        char input = command.getInput();
        return FINISH_CODE == input;
    }
}
