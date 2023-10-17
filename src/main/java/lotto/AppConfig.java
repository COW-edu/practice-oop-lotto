package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;


public class AppConfig {

    private static LottoController lottoController;

    public void setLottoController() {
        this.lottoController = new LottoController(new InputView(), new OutputView(), new LottoService());
    }

    public void runLotto() {
        lottoController.lottoGameRun();
    }
}
