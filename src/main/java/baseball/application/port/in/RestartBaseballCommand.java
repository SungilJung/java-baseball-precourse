package baseball.application.port.in;

import baseball.util.RestartCheck;
import baseball.util.SelfValidating;

public class RestartBaseballCommand extends SelfValidating<RestartBaseballCommand> {

    @RestartCheck
    private final String userInput;

    public RestartBaseballCommand(String userInput) {
        this.userInput = userInput;
        super.validateSelf();
    }

    public char getInput() {
        return userInput.charAt(0);
    }

}
