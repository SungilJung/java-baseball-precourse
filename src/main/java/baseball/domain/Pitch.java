package baseball.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor()
@EqualsAndHashCode(callSuper = false)
public class Pitch {
    @Getter
    final int value;
}
