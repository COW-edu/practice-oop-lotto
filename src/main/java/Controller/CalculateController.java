package Controller;

import Model.*;
import View.OutputView;

import java.util.List;

public class CalculateController implements Controllable{
    Calculator calculator = new Calculator();
    OutputView outputView = new OutputView();

    @Override
    public void process(){
        List<Prize> prizeList = calculator.calculateResult(PurchasedLotto.getPurchasedLotto(), BonusNum.getBonusNumber());
        outputView.printResult(calculator.setPrize(prizeList));

        double totalProfitRate = calculator.calculateProfit(prizeList, Money.getMoney());
        outputView.printProfit(totalProfitRate);
    }
}
