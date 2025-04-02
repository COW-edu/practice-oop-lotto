package config;

import controller.LottoController;
import view.Input;
import view.InputView;
import view.OutputView;

public class AppConfig {
    public Input inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoController lottoController() {
        return new LottoController(this.inputView(), this.outputView());
    }
}
