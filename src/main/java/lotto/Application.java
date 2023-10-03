package lotto;
import View.Input;
import View.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Money money = new Money(input.InputMoney());

        int amountOfLotto = money.getAmountOfLotto();
        PurchasedLotto purchasedLotto = new PurchasedLotto(amountOfLotto);
        List<Lotto> purchasedLottoList = purchasedLotto.getPurchasedLotto();

        System.out.println(amountOfLotto + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottoList) {
            System.out.println(lotto);
        }

        WinningNum winningNum = new WinningNum(input.InputLottoNums());
        BonusNum bonusNum = new BonusNum(input.InputBonus());

        List<Prize> prizeList = Calculate.calculateResult(purchasedLottoList, winningNum, bonusNum.getBonusNumber());

        Output.printResult(prizeList);

        double totalProfitRate = Calculate.calculateProfit(prizeList, money.getMoney());
        Output.printProfit(totalProfitRate);
    }
}