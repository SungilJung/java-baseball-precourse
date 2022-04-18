package baseball.application.port.in;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestartBaseballCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", "1234", "abc", "012", "111", "12", "a12", "0"})
    void 예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RestartBaseballCommand(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 데이터_반환_테스트(String input) {
        assertEquals(input.charAt(0), new RestartBaseballCommand(input).getInput());
    }
}