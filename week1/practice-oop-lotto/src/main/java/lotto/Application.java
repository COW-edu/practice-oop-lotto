package lotto;

import view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainSystem main = new MainSystem();
        View view = new View();
        LottoMachine lottoMachine = new LottoMachine();

        main.initialize(view, lottoMachine);

        main.start();

    }
}
