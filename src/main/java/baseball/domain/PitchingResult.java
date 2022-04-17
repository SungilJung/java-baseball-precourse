package baseball.domain;

import java.util.EnumMap;
import java.util.Map;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class PitchingResult {
    public enum Kind {
        BALL, STRIKE, NOTHING
    }

    final Map<Kind, PitchingResultCount> resultMap = new EnumMap<>(Kind.class);

    public void increase(Kind kind) {
        PitchingResultCount count = resultMap.getOrDefault(kind, new PitchingResultCount(0));
        resultMap.put(kind, count.increase());
    }

    public PitchingResultCount getCount(Kind kind) {
        return resultMap.getOrDefault(kind, new PitchingResultCount(0));
    }
}
