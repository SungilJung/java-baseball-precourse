package baseball.application.port.in;

public interface RestartBaseballUsecase {

    boolean isFinished(RestartBaseballCommand command);
}
