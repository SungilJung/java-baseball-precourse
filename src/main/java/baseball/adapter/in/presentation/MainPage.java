package baseball.adapter.in.presentation;

import baseball.adapter.out.ephemeral.AiPitchesAdapter;

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

            boolean isValid = input.length() == 1 && (input.charAt(0) == '1' || input.charAt(0) == '2');

            if(isValid) {
                isFinished[0] = '2' == input.charAt(0);
            }else {
                throw  new IllegalArgumentException();
            }

        });

        return isFinished[0];
    }
}
