package lotto.controller;

import lotto.constant.LottoPrize;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        String purchaseAmountInput = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountInput);
        int lottoCount = purchaseAmount.getLottoCount();
        outputView.printLottoCount(lottoCount);

        List<Lotto> myLottos = lottoMachine.generateLottos(lottoCount);
        outputView.printMyLottos(myLottos);

        String winningNumbersInput = inputView.inputWinningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput);

        String bonusNumberInput = inputView.inputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInput, winningNumbers);

        LottoChecker lottoChecker = new LottoChecker(myLottos, winningNumbers, bonusNumber.getBonusNumber());
        Map<LottoPrize, Integer> winningResults = lottoChecker.checkWinningResults();

        ProfitCalculator profitCalculator = new ProfitCalculator(purchaseAmount.getPurchaseAmount(), winningResults);
        double profitRate = profitCalculator.calculateProfitRate();

        outputView.printWinningResults(winningResults);
        outputView.printProfitRate(profitRate);
    }
}