package controller;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoSeller lottoSeller = new LottoSeller();
        WinningChecker winningChecker = new WinningChecker();
        FlowController flowController = new FlowController(inputView, outputView, lottoSeller, winningChecker);
        flowController.run();
    }
}
