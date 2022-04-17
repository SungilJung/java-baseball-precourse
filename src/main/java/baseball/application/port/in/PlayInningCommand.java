package baseball.application.port.in;

import baseball.domain.Pitch;
import baseball.domain.Pitches;
import baseball.util.PitchCheck;
import baseball.util.SelfValidating;

public class PlayInningCommand extends SelfValidating<PlayInningCommand> {

    @PitchCheck
    private final String userInput;

    private Pitches playerPitches;

    public PlayInningCommand(String userInput) {
        this.userInput = userInput;
        super.validateSelf();
    }

    public Pitches getPlayerPitches() {

        if (playerPitches == null) {
            playerPitches = createPitches();
        }

        return playerPitches;
    }

    private Pitches createPitches() {
        Pitches pitches = new Pitches();

        for (char element : userInput.toCharArray()) {
            pitches.add(new Pitch(Character.getNumericValue(element)));
        }

        return pitches;
    }
}
