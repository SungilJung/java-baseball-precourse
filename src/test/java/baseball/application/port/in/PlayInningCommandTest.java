package baseball.application.port.in;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.Pitch;
import baseball.domain.Pitches;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayInningCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "1234", "abc", "012", "111", "12", "a12"})
    void 예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayInningCommand(input));
    }

    @Test
    void 유저_구종_테스트() {

        Pitches expectedPitches = new Pitches();
        expectedPitches.add(new Pitch(1));
        expectedPitches.add(new Pitch(2));
        expectedPitches.add(new Pitch(3));

        PlayInningCommand playInningCommand = new PlayInningCommand("123");
        Pitches playerPitches = playInningCommand.getPlayerPitches();

        assertThat(playerPitches).isEqualTo(expectedPitches);

        System.out.println(playerPitches.toString());

    }
}