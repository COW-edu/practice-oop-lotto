package lotto;

import config.AppConfig;
import controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig config = new AppConfig();
        LottoController lottoController = config.lottoController();
        lottoController.run();
    }
}
