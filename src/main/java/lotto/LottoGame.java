package lotto;

import java.util.Map;

public class LottoGame {

    private final InputHandler inputHandler;
    private final ResultCalculator resultCalculator;
    private final OutputHandler outputHandler;

    public LottoGame(InputHandler inputHandler, ResultCalculator resultCalculator, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.resultCalculator = resultCalculator;
        this.outputHandler = outputHandler;
    }

    public void start() {
        PurchaseInfo purchaseinfo = PurchaseInfo.buy(inputHandler.getMoney());
        outputHandler.printLottos(purchaseinfo.getBoughtLottos());

        WinningInfo winningInfo = WinningInfo.fromInput(inputHandler);
        Map<ResultConstants, Integer> result = resultCalculator.calculateResults(
                purchaseinfo.getBoughtLottos(),
                winningInfo.getWinningNumbers(),
                winningInfo.getBonusNumber()
        );
        outputHandler.printStatistics(result);
        outputHandler.printProfitRate(resultCalculator.calculateProfitRate(result, purchaseinfo.getMoney()));
    }
}

