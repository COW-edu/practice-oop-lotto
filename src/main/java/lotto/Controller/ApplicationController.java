package lotto.Controller;

import lotto.View.InputView;

public class ApplicationController {
    InputView inputView = new InputView();

    public ApplicationController() {
        inputView.inputMoney();
    }
}
