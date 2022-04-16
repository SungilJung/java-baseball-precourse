package baseball.adapter.out.ephemeral;

import baseball.application.port.out.GenerateAiPitchesPort;
import baseball.application.port.out.GetAiPitchesPort;
import baseball.domain.Pitch;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AiPitchesAdapter implements GetAiPitchesPort, GenerateAiPitchesPort {
    private Map<Pitch, Integer> aiPitches = new HashMap<>();

    @Override
    public void generate() {
        aiPitches = new HashMap<>();
        Set<Integer> randomPitches = new HashSet<>();

        while (randomPitches.size() < 3) {
            randomPitches.add(Randoms.pickNumberInRange(1, 9));
        }

        int index = 0;

        for (int pitch : randomPitches) {
            aiPitches.put(new Pitch(pitch), index);
            index++;
        }
    }

    @Override
    public Map<Pitch, Integer> getAiPitches() {
        return aiPitches;
    }
}
