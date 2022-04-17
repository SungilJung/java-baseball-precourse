package baseball.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class PitchingResultCount {

    @Getter
    final int count;

    PitchingResultCount increase() {
        return new PitchingResultCount(count+1);
    }
}
