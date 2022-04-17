package baseball.adapter.out.ephemeral;

import baseball.application.port.out.GenerateAiPitchesPort;
import baseball.application.port.out.GetAiPitchesPort;
import baseball.domain.Pitch;
import baseball.domain.Pitches;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class AiPitchesAdapter implements GetAiPitchesPort, GenerateAiPitchesPort {
    private Pitches aiPitches;

    @Override
    public void generate() {
        aiPitches = new Pitches();
        Set<Integer> randomValueSet = getRandomValueSet();

        for (int value : randomValueSet) {
            aiPitches.add(new Pitch(value));
        }

    }

    Set<Integer> getRandomValueSet() {
        Set<Integer> values = new LinkedHashSet<>();

        while (values.size() < 3) {
            values.add(Randoms.pickNumberInRange(1, 9));
        }

        return values;
    }

    @Override
    public Pitches getAiPitches() {
        return aiPitches;
    }
}
