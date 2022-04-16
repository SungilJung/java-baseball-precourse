package baseball.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GameResult {
    private static final int FINISH_COUNT = 3;

    @Getter
    int strikeCount;
    @Getter
    int ballCount;

    public boolean isFinish() {
        return strikeCount == FINISH_COUNT;
    }
}
