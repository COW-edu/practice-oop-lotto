package controller;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController();
        WinningCheckController winningCheckController = new WinningCheckController();
        FrontController frontController = new FrontController(inputView, outputView, lottoController, winningCheckController);
        frontController.run();
    }
}
