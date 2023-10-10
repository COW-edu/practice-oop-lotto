package Controller;

import View.Input;
import View.Output;
import Model.*;

import java.util.List;

public class Controller {
    public static void Start(){
        Input input = new Input();
        System.out.println("금액을 입력하시오: ");
        Money money = new Money(input.InputMoney());

        new PurchasedLotto(Money.getAmountOfLotto());

        System.out.println(Money.getAmountOfLotto() + "개를 구매했습니다.");
        for (Lotto lotto : PurchasedLotto.getPurchasedLotto()) {
            System.out.println(lotto);
        }

        System.out.println("로또 번호를 입력하시오(1~45): ");
        WinningNum winningNum = new WinningNum(input.InputLottoNums());

        System.out.println("보너스 번호를 입력하시오(1~45): ");
        BonusNum bonusNum = new BonusNum(input.InputBonus());

        List<Prize> prizeList = Calculator.calculateResult(PurchasedLotto.getPurchasedLotto(), winningNum, bonusNum.getBonusNumber());

        Output.printResult(prizeList);

        double totalProfitRate = Calculator.calculateProfit(prizeList, money.getMoney());
        Output.printProfit(totalProfitRate);
    }
}
