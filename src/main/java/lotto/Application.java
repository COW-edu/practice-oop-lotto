package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;


public class Application{

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        InputView inputView = appConfig.inputView();
        OutputView outputView = appConfig.outputView();
        LottoRun lottoRun = new LottoRun(inputView, outputView);
        lottoRun.run();
    }
}
