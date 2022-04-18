package baseball.adapter.in.presentation;

import baseball.adapter.out.ephemeral.AiPitchesAdapter;
import baseball.application.port.in.RestartBaseballCommand;
import baseball.application.port.in.RestartBaseballUsecase;
import baseball.application.service.RestartBaseballService;

public class MainPage implements Page {

    @Override
    public void execute() {
        boolean isFinished;
        do {
            new InningPage(new AiPitchesAdapter()).execute();
            isFinished = checkRestart();
        } while (!isFinished);
    }

    private boolean checkRestart() {
        boolean[] isFinished = new boolean[1];

        new BaseballConsole("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.\n").execute(input -> {
            RestartBaseballUsecase restartBaseballUsecase = new RestartBaseballService();
            isFinished[0] = restartBaseballUsecase.isFinished(new RestartBaseballCommand(input));
        });

        return isFinished[0];
    }
}
