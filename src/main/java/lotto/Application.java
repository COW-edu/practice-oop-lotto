package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LMain main = new LMain();
        LView view = new LView();
        LottoMachine lottoMachine = new LottoMachine();

        main.initialize(view, lottoMachine);

        main.start();

    }
}
