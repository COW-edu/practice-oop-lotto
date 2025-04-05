package config;

import controller.LottoController;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import view.OutputViewImpl;

public class AppConfig {
    public InputView inputView() {
        return new InputViewImpl();
    }

    public OutputView outputView() {
        return new OutputViewImpl();
    }

    public LottoController lottoController() {
        return new LottoController(this.inputView(), this.outputView());
    }
}
