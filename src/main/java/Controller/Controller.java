package Controller;

import View.Input;
import View.Output;
import Model.*;

import java.util.List;

public class Controller {
    public Controller(){

    }
    public void Start(){
        Input input = new Input();
        Output output = new Output();

        output.printMoneyMessage();
        String moneyInput = input.getInput();
        Money money = new Money(moneyInput);

        new PurchasedLotto(Money.getAmountOfLotto());

        output.printBuyLottoMessage();
        for (Lotto lotto : PurchasedLotto.getPurchasedLotto()) {
            System.out.println(lotto);
        }

        output.printLottoNumberMessage();
        String lottoNumsInput = input.getInput();
        WinningNum winningNumber = new WinningNum(lottoNumsInput);

        output.printBonusNumberMessage();
        String bonusInput = input.getInput();
        BonusNum bonusNumber = new BonusNum(bonusInput);

        List<Prize> prizeList = Calculator.calculateResult(PurchasedLotto.getPurchasedLotto(), winningNumber, bonusNumber.getBonusNumber());

        Output.printResult(prizeList);

        double totalProfitRate = Calculator.calculateProfit(prizeList, money.getMoney());
        Output.printProfit(totalProfitRate);
    }
}
