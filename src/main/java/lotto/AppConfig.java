package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoFrontController;
import lotto.controller.LottoPurchaseController;
import lotto.controller.WinningLottoController;
import lotto.view.InputView;
import lotto.view.OutputView;


public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;

    public AppConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void runLotto() {
        LottoFrontController lottoFrontController = new LottoFrontController(inputView, outputView);
        lottoFrontController.run();
    }
}
