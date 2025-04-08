package lotto.View;

import lotto.Model.Lotto;

import java.util.List;

public class BuyerInteractionHandler {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;

    public BuyerInteractionHandler() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public int requestMoney() {
        return inputHandler.getPurchasingMoney();
    }
    public void showBuyResult(int count, List<String> lottos) {
        outputHandler.outputLottos(count, lottos);
    }
    public String requestWinningNumber() {
        return inputHandler.getWinningNumber();
    }
    public int requestBonusNumber() {
        return inputHandler.getBonusNumber();
    }
    public void sayProfit(List<Integer> countStatics, double profitRate) {
        outputHandler.outputWinningStatics(countStatics, profitRate);
    }

}
