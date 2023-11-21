package Controller;

import View.InputView;
import View.OutputView;
import Model.*;

import java.util.List;

public class Controller {
    private boolean Start = true;

    private final InputMoneyController inputMoneyController;
    private final MakePurchasedLottoController makePurchasedLottoController;
    private final MakeWinningNumbersController makeWinningNumbersController;
    private final MakeBonusNumberController makeBonusNumberController;
    private final PrizeController prizeController;

    public Controller(){
        inputMoneyController = new InputMoneyController();
        makePurchasedLottoController = new MakePurchasedLottoController();
        makeWinningNumbersController = new MakeWinningNumbersController();
        makeBonusNumberController = new MakeBonusNumberController();
        prizeController = new PrizeController();
    }
    public void Start() {
        inputMoneyController.service();
        makePurchasedLottoController.service();
        makeWinningNumbersController.service();
        makeBonusNumberController.service();
        prizeController.service();
    }
}
