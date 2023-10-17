package Controller;

import View.Input;
import View.Output;
import Model.*;

import java.util.List;

public class Controller {
    Input input = new Input();
    Output output = new Output();
    Calculator calculator = new Calculator();
    public Controller(){

    }
    public void Start(){
        start_InputMoney();
        start_MakePurchasedLotto();
        start_MakeWinningNumbers();
        start_MakeBonusNumber();
        start_Prize();
    }

    public void start_InputMoney(){
        output.printMoneyMessage();
        String moneyInput = input.getInput();
        Money money = new Money(moneyInput);
        money.validate_Money(moneyInput);
    }

    public void start_MakePurchasedLotto(){
        new PurchasedLotto(Money.getAmountOfLotto());

        output.printBuyLottoMessage();
        for (Lotto lotto : PurchasedLotto.getPurchasedLotto()) {
            lotto.validate_Lotto();
            System.out.println(lotto);
        }
    }

    public void start_MakeWinningNumbers(){
        output.printLottoNumberMessage();
        String lottoNumsInput = input.getInput();
        WinningNum winningNumber = new WinningNum(lottoNumsInput);
        winningNumber.validate_Lotto();
    }

    public void start_MakeBonusNumber(){
        output.printBonusNumberMessage();
        String bonusInput = input.getInput();
        BonusNum bonusNumber = new BonusNum(bonusInput);
        bonusNumber.validate_Bonus(String.valueOf(bonusInput));
    }

    public void start_Prize(){
        List<Prize> prizeList = calculator.calculateResult(PurchasedLotto.getPurchasedLotto(), BonusNum.getBonusNumber());
        output.printResult(calculator.setPrize(prizeList));

        double totalProfitRate = calculator.calculateProfit(prizeList, Money.getMoney());
        output.printProfit(totalProfitRate);
    }
}
