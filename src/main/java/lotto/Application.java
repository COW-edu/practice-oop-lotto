package lotto;

import config.AppConfig;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig config = new AppConfig();
        InputView inputView = config.inputView();
        inputView.getPurchaseAmount();
    }
}
