package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.PitchingResult.Kind;
import org.junit.jupiter.api.Test;

class PitchingResultTest {

    @Test
    void 증가_테스트() {
        PitchingResult pitchingResult = new PitchingResult();

        pitchingResult.increase(Kind.STRIKE);
        pitchingResult.increase(Kind.STRIKE);
        pitchingResult.increase(Kind.BALL);

        assertAll(() -> assertEquals(new PitchingResultCount(2), pitchingResult.getCount(Kind.STRIKE)),
                () -> assertEquals(new PitchingResultCount(1), pitchingResult.getCount(Kind.BALL)),
                () -> assertEquals(new PitchingResultCount(0), pitchingResult.getCount(Kind.NOTHING)));

    }

}