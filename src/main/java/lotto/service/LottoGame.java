package lotto.service;

import lotto.controller.LottoGenerator;
import lotto.controller.ResultCalculator;
import lotto.domain.PurchaseInfo;
import lotto.utils.ResultConstants;
import lotto.domain.WinningInfo;
import java.util.Map;

public class LottoGame {

    private final InputHandler inputHandler;
    private final ResultCalculator resultCalculator;
    private final OutputHandler outputHandler;
    private final LottoGenerator lottoGenerator;

    public LottoGame(InputHandler inputHandler, ResultCalculator resultCalculator, OutputHandler outputHandler, LottoGenerator lottoGenerator) {
        this.inputHandler = inputHandler;
        this.resultCalculator = resultCalculator;
        this.outputHandler = outputHandler;
        this.lottoGenerator = lottoGenerator;
    }

    public void start() {
        PurchaseInfo purchaseInfo = PurchaseProcess();
        WinningInfo winningInfo = WinningInfo.fromInput(inputHandler);
        Map<ResultConstants, Integer> result = resultCalculator.calculateResults(
                purchaseInfo.getBoughtLottos(), winningInfo.getWinningNumbers(), winningInfo.getBonusNumber()
        );
        printresult(result, purchaseInfo);
    }

    private void printresult(Map<ResultConstants, Integer> result, PurchaseInfo purchaseInfo) {
        outputHandler.printStatistics(result);
        outputHandler.printProfitRate(resultCalculator.calculateProfitRate(result, purchaseInfo.getMoney()));
    }

    private PurchaseInfo PurchaseProcess() {
        PurchaseInfo purchaseInfo = PurchaseInfo.create(inputHandler.getMoney(), lottoGenerator);
        outputHandler.printLottos(purchaseInfo.getBoughtLottos());
        return purchaseInfo;
    }
}

