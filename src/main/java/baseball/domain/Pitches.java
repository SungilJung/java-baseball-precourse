package baseball.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Pitches {

    private final Map<Pitch, PitchIndex> pitchMap = new HashMap<>();

    public void add(Pitch pitch) {
        pitchMap.putIfAbsent(pitch, new PitchIndex(pitchMap.size()));
    }

    public PitchingResult compareTo(Pitches target) {
        PitchingResult result = new PitchingResult();

        for (Entry<Pitch, PitchIndex> entry : this.pitchMap.entrySet()) {
            PitchingResult.Kind kind = getPitchingResultKind(entry, target.pitchMap);
            result.increase(kind);
        }

        return result;

    }

    private PitchingResult.Kind getPitchingResultKind(Entry<Pitch, PitchIndex> src, Map<Pitch, PitchIndex> targetMap) {
        PitchingResult.Kind kind = PitchingResult.Kind.NOTHING;

        PitchIndex index = targetMap.getOrDefault(src.getKey(), PitchIndex.NOT_FOUND);

        if (!index.equals(PitchIndex.NOT_FOUND)) {
            kind = index.equals(src.getValue()) ? PitchingResult.Kind.STRIKE : PitchingResult.Kind.BALL;
        }

        return kind;
    }

    public Map<Pitch, PitchIndex> getPitchMap() {
        return Collections.unmodifiableMap(pitchMap);
    }
}
