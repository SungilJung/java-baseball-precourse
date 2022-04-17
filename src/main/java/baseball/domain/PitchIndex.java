package baseball.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class PitchIndex {

    public static final PitchIndex NOT_FOUND = new PitchIndex(-1);

    @Getter
    final int value;
}
