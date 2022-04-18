package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.PitchingResult.Kind;
import org.junit.jupiter.api.Test;

class PitchesTest {

    @Test
    void pitch_추가_테스트() {

        Pitches pitches = new Pitches();
        pitches.add(new Pitch(1));
        pitches.add(new Pitch(1));
        pitches.add(new Pitch(1));

        assertEquals(1, pitches.getPitchMap().size());

    }

    @Test
    void 스트라이크_테스트() {
        Pitches pitches = new Pitches();
        pitches.add(new Pitch(1));
        pitches.add(new Pitch(2));
        pitches.add(new Pitch(3));

        PitchingResult pitchingResult = pitches.compareTo(pitches);

        assertEquals(new PitchingResultCount(3), pitchingResult.getCount(Kind.STRIKE));
        assertTrue(pitchingResult.isFinish());

    }

    @Test
    void 볼_테스트() {
        Pitches p1 = new Pitches();
        p1.add(new Pitch(1));
        p1.add(new Pitch(2));
        p1.add(new Pitch(3));

        Pitches p2 = new Pitches();
        p2.add(new Pitch(2));
        p2.add(new Pitch(3));
        p2.add(new Pitch(1));

        PitchingResult pitchingResult = p1.compareTo(p2);

        assertEquals(new PitchingResultCount(3), pitchingResult.getCount(Kind.BALL));
        assertFalse(pitchingResult.isFinish());
    }

    @Test
    void 낫씽_테스트() {
        Pitches p1 = new Pitches();
        p1.add(new Pitch(1));
        p1.add(new Pitch(2));
        p1.add(new Pitch(3));

        Pitches p2 = new Pitches();
        p2.add(new Pitch(4));
        p2.add(new Pitch(5));
        p2.add(new Pitch(6));

        PitchingResult pitchingResult = p1.compareTo(p2);

        assertEquals(new PitchingResultCount(3), pitchingResult.getCount(Kind.NOTHING));
        assertFalse(pitchingResult.isFinish());

    }

    @Test
    void 혼합_테스트() {
        Pitches p1 = new Pitches();
        p1.add(new Pitch(1));
        p1.add(new Pitch(2));
        p1.add(new Pitch(3));

        Pitches p2 = new Pitches();
        p2.add(new Pitch(1));
        p2.add(new Pitch(3));
        p2.add(new Pitch(4));

        PitchingResult pitchingResult = p1.compareTo(p2);

        assertAll(() -> assertEquals(new PitchingResultCount(1), pitchingResult.getCount(Kind.STRIKE)),
                () -> assertEquals(new PitchingResultCount(1), pitchingResult.getCount(Kind.BALL)),
                () -> assertEquals(new PitchingResultCount(1), pitchingResult.getCount(Kind.NOTHING)));
        assertFalse(pitchingResult.isFinish());

    }

}