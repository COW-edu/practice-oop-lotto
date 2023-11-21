package Controller;

import Model.Lotto;
import Model.Money;
import Model.PurchasedLotto;
import Repository.LottoRepository;
import View.InputView;
import View.OutputView;

public class BuyLottoController implements Controllable{
    private static final LottoRepository lottoRepository = LottoRepository.getInstance();

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
            Lotto saveLotto = lottoRepository.save(lotto);
            System.out.println(saveLotto);
        }
    }
}
