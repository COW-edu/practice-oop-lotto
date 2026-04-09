package lotto;

import global.AppConfig;

public class Application {
    public static void main(String[] args) {
        // 1. 시작점
        AppConfig appConfig = new AppConfig();
        // run() 호출
        appConfig.lottoController().run();
    }
}
