package baseball.adapter.in.presentation;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Consumer;

public class BaseballConsole {

    private final String message;

    public BaseballConsole(String message) {
        this.message = message;
    }

    public void execute(Consumer<String> callback) {
        System.out.print(message);
        callback.accept(Console.readLine());
    }

    public void print() {
        System.out.println(message);
    }
}
