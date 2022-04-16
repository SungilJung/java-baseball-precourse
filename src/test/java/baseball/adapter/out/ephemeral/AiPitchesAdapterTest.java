package baseball.adapter.out.ephemeral;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.Pitch;
import java.util.Map;
import org.junit.jupiter.api.RepeatedTest;

class AiPitchesAdapterTest {

    @RepeatedTest(100)
    void AI_구종_테스트() {

        AiPitchesAdapter aiPitchesAdapter = new AiPitchesAdapter();
        aiPitchesAdapter.generate();

        Map<Pitch, Integer> aiPitches = aiPitchesAdapter.getAiPitches();
        assertTrue(aiPitches.size() == 3 && aiPitches.keySet().stream()
                .allMatch(pitch -> pitch.getValue() > 0 && pitch.getValue() < 10));

    }

}