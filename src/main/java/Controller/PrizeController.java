package Controller;

import Model.*;
import View.OutputView;

import java.util.List;

public class PrizeController {
    Calculator calculator = new Calculator();
    OutputView outputView = new OutputView();

    public void service(){
        List<Prize> prizeList = calculator.calculateResult(PurchasedLotto.getPurchasedLotto(), BonusNum.getBonusNumber());
        outputView.printResult(calculator.setPrize(prizeList));

        double totalProfitRate = calculator.calculateProfit(prizeList, Money.getMoney());
        outputView.printProfit(totalProfitRate);
    }
}
