package baseball.application.port.out;

import baseball.domain.Pitch;
import java.util.Map;

public interface GetAiPitchesPort {
    Map<Pitch, Integer> getAiPitches();
}
