package global;

import controller.LottoController;
import view.InputView;
import view.OutputView;

public class AppConfig {
    // 의존성 주입
    public LottoController lottoController() {
        return new LottoController(userInput(), userOutput());
    }

    public InputView userInput() {
        return new InputView();
    }

    public OutputView userOutput() {
        return new OutputView();
    }
}
