package baseball.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PitchingResultCount {

    @Getter
    final int count;

    PitchingResultCount increase() {
        return new PitchingResultCount(count+1);
    }
}
