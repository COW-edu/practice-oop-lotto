package Controller;

import Model.Lotto;
import Model.Money;
import Model.PurchasedLotto;
import View.OutputView;

public class MakePurchasedLottoController {
    OutputView outputView = new OutputView();
    public void service(){
        new PurchasedLotto(Money.getAmountOfLotto());

        outputView.printBuyLottoMessage();
        for (Lotto lotto : PurchasedLotto.getPurchasedLotto()) {
            lotto.validate_Lotto();
            System.out.println(lotto);
        }
    }
}
