package controller;

import view.InputView;
import view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        int purchaseAmount=inputView.getPurchaseAmount();
        int numberOfLottos=purchaseAmount/1000;

        outputView.printPurchaseCount(numberOfLottos);

    }
}
