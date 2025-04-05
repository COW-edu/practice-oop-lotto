package config;

import controller.LottoController;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import view.OutputViewImpl;

public class AppConfig {
    public InputViewImpl inputView() {
        return new InputView();
    }

    public OutputViewImpl outputView() {
        return new OutputView();
    }

    public LottoController lottoController() {
        return new LottoController(this.inputView(), this.outputView());
    }
}
