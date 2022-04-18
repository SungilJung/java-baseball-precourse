package baseball.adapter.in.presentation;

import baseball.adapter.out.ephemeral.AiPitchesAdapter;
import baseball.application.port.in.PlayInningCommand;
import baseball.application.port.in.PlayInningUsecase;
import baseball.application.service.PlayInningService;
import baseball.domain.PitchingResult;
import baseball.domain.PitchingResult.Kind;
import baseball.domain.PitchingResultCount;

public class InningPage implements Page {

    private final AiPitchesAdapter aiPitchesAdapter;
    private final PlayInningUsecase playInningUsecase;


    public InningPage(AiPitchesAdapter aiPitchesAdapter) {
        this.aiPitchesAdapter = aiPitchesAdapter;
        playInningUsecase = new PlayInningService(aiPitchesAdapter);
    }

    @Override
    public void execute() {
        aiPitchesAdapter.generate();
        boolean isFinish;

        do {
            PitchingResult result = playInning();
            printPitchingResult(result);
            isFinish = result.isFinish();
        } while (!isFinish);

        new BaseballConsole("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n").print();
    }

    private PitchingResult playInning() {
        PitchingResult[] result = new PitchingResult[1];

        new BaseballConsole("숫자를 입력해주세요:").execute(
                input -> result[0] = playInningUsecase.playInning(new PlayInningCommand(input)));

        return result[0];
    }

    private void printPitchingResult(PitchingResult result) {
        PitchingResultCount strikeCount = result.getCount(Kind.STRIKE);
        String strikeMessage = 0 != strikeCount.getCount() ? strikeCount.getCount() + "스트라이크" : "";

        PitchingResultCount ballCount = result.getCount(Kind.BALL);
        String ballMessage = 0 != ballCount.getCount() ? ballCount.getCount() + "볼" : "";

        String message = strikeMessage.isEmpty() && ballMessage.isEmpty() ? "낫싱" : ballMessage + " " + strikeMessage;
        new BaseballConsole(message).print();
    }

}
