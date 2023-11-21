package Controller;

import Model.Lotto;
import Model.Money;
import Model.PurchasedLotto;
import View.InputView;
import View.OutputView;

public class BuyLottoController implements Controllable{
    OutputView outputView = new OutputView();
    @Override
    public void process(){
        outputView.printMoneyMessage();
        String moneyInput = InputView.getInput();
        Money money = new Money(moneyInput);
        money.validate_Money(moneyInput);

        new PurchasedLotto(Money.getAmountOfLotto());

        outputView.printBuyLottoMessage();
        for (Lotto lotto : PurchasedLotto.getPurchasedLotto()) {
            lotto.validate_Lotto();
            System.out.println(lotto);
        }
    }
}
