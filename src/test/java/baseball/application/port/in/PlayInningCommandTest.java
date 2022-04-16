package baseball.application.port.in;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.Pitch;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayInningCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "1234", "abc", "012", "111"})
    void 예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayInningCommand(input));
    }

    @Test
    void 유저_구종_테스트() {
        Map<Pitch, Integer> expectedMap = new HashMap<>();
        expectedMap.put(new Pitch(1), 0);
        expectedMap.put(new Pitch(2), 1);
        expectedMap.put(new Pitch(3), 2);

        PlayInningCommand playInningCommand = new PlayInningCommand("123");
        Map<Pitch, Integer> playerPitches = playInningCommand.getPlayerPitches();

        assertThat(playerPitches).isEqualTo(expectedMap);

        System.out.println(playerPitches.toString());

    }
}