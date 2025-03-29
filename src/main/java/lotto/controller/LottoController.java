package lotto.controller;

import lotto.domain.BonusNumberManager;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmountManager;
import lotto.domain.WinningNumbersManager;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PurchaseAmountManager purchaseAmountManager = new PurchaseAmountManager();
    private final LottoMachine lottoMachine = new LottoMachine();
    private final WinningNumbersManager winningNumbersManager = new WinningNumbersManager();
    private final BonusNumberManager bonusNumberManager = new BonusNumberManager();

    public void run() {
        String purchaseAmountInput = inputView.inputPurchaseAmount();
        purchaseAmountManager.checkPurchaseAmountManager(purchaseAmountInput);
        int lottoCount = purchaseAmountManager.getLottoCount();
        outputView.printLottoCount(lottoCount);

        List<lotto.Lotto> myLottos = lottoMachine.generateLottos(lottoCount);
        outputView.printMyLottos(myLottos);

        String winningNumbersInput = inputView.inputWinningNumbers();
        winningNumbersManager.checkWinningNumbers(winningNumbersInput);
        List<Integer> winningNumbers = winningNumbersManager.getWinningNumbers();

        String bonusNumberInput = String.valueOf(inputView.inputBonusNumber());
        bonusNumberManager.checkBonusNumber(bonusNumberInput, winningNumbers);
        int bonusNumber = bonusNumberManager.getBonusNumber();

    }
}