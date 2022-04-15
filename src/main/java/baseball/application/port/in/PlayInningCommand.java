package baseball.application.port.in;

import baseball.util.PitchCheck;
import baseball.util.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;


@Value
@EqualsAndHashCode(callSuper = false)
public class PlayInningCommand extends SelfValidating<PlayInningCommand> {

    @PitchCheck
    String userInput;

    public PlayInningCommand(String userInput) {
        this.userInput = userInput;
        super.validateSelf();
    }
}
