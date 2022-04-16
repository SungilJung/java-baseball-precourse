package baseball.application.port.in;

import baseball.domain.Pitch;
import baseball.util.PitchCheck;
import baseball.util.SelfValidating;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayInningCommand extends SelfValidating<PlayInningCommand> {

    @PitchCheck
    private final String userInput;

    private Map<Pitch, Integer> playerPitchMap;

    public PlayInningCommand(String userInput) {
        this.userInput = userInput;
        super.validateSelf();
    }

    public Map<Pitch, Integer> getPlayerPitches() {

        if (playerPitchMap == null) {
            playerPitchMap = IntStream.range(0, userInput.length()).boxed().collect(
                    Collectors.toMap(index -> new Pitch(Character.getNumericValue(userInput.charAt(index))),
                            index -> index));
        }

        return playerPitchMap;
    }
}
