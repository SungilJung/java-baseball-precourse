package baseball.application.port.in;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayInningCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "1234", "abc", "012", "111"})
    void 예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayInningCommand(input));
    }
}