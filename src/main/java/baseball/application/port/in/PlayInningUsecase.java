package baseball.application.port.in;

import baseball.domain.GameResult;

public interface PlayInningUsecase {
    GameResult playInning(PlayInningCommand command);
}
