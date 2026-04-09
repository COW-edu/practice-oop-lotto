package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), lottoService());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoService lottoService() {return new LottoService(); }
}
