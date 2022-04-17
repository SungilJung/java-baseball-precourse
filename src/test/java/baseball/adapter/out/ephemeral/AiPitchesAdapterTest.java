package baseball.adapter.out.ephemeral;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.Pitch;
import baseball.domain.PitchIndex;
import baseball.domain.Pitches;
import java.util.Map;
import org.junit.jupiter.api.RepeatedTest;

class AiPitchesAdapterTest {

    @RepeatedTest(100)
    void AI_구종_테스트() {

        AiPitchesAdapter aiPitchesAdapter = new AiPitchesAdapter();
        aiPitchesAdapter.generate();

        Pitches aiPitches = aiPitchesAdapter.getAiPitches();
        Map<Pitch, PitchIndex> pitchMap = aiPitches.getPitchMap();

        int invalidCount = 0;

        assertTrue(pitchMap.size() == 3 && pitchMap.keySet().stream()
                .allMatch(pitch -> pitch.getValue() > 0 && pitch.getValue() < 10));

    }

}