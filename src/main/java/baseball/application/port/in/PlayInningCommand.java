package baseball.application.port.in;

import baseball.domain.Pitch;
import baseball.util.PitchCheck;
import baseball.util.SelfValidating;
import java.util.HashMap;
import java.util.Map;

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
            playerPitchMap = createPitches();
        }

        return playerPitchMap;
    }

    private Map<Pitch, Integer> createPitches() {
        Map<Pitch, Integer> pitchMap = new HashMap<>();

        for (int index = 0; index < userInput.length(); index++) {
            char element = userInput.charAt(index);
            pitchMap.put(new Pitch(Character.getNumericValue(element)), index);
        }

        return pitchMap;
    }
}
