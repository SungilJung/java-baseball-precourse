package baseball.application.port.in;

import baseball.domain.PitchingResult;

public interface PlayInningUsecase {
    PitchingResult playInning(PlayInningCommand command);
}
