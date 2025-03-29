package lotto.View;

import lotto.Model.Lotto;

import java.util.List;

public class InteractBuyer {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;

    public InteractBuyer(){
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public int requestMoney(){
        return inputHandler.getPurchasingMoney();
    }
    public void showBuyResult(int count, List<Lotto> lottoes){
        outputHandler.outputLottos(count, lottoes);
    }
    public String requestWinningNumber(){
        return inputHandler.getWinningNumber();
    }
    public int requestBonusNumber(){
        return inputHandler.getBonusNumber();
    }
    public void sayProfit(List<Integer> countStatics, int confirmedMoney, int purchasingMoney){
        outputHandler.outputWinningStatics(countStatics, confirmedMoney, purchasingMoney);
    }

}
