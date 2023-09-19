package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;


public class Application {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    LottoController lottoController = appConfig.lottoController();
    InputView inputView = new InputView(lottoController);
    OutputView outputView = new OutputView(lottoController);
    LottoRun lottoRun = new LottoRun(inputView, outputView);
    lottoRun.run();
  }
}
