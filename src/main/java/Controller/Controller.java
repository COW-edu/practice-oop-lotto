package Controller;

import View.InputView;
import View.OutputView;
import Model.*;

import java.util.List;

public class Controller {
    private boolean Start = true;

    private final BuyLottoController inputMoneyController;
    private final MakeWinningNumbersController makeWinningNumbersController;
    private final MakeBonusNumberController makeBonusNumberController;
    private final PrizeController prizeController;

    public Controller(){
        inputMoneyController = new BuyLottoController();
        makeWinningNumbersController = new MakeWinningNumbersController();
        makeBonusNumberController = new MakeBonusNumberController();
        prizeController = new PrizeController();
    }
    public void Start() {
        inputMoneyController.service();
        makeWinningNumbersController.service();
        makeBonusNumberController.service();
        prizeController.service();
    }
}
