package lotto;

import java.util.ArrayList;
import java.util.List;


public class LMain {
    private LView view;
    private LottoMachine lottoMachine;

    public LMain() {

    }
    public void start() {
        int price = view.inputLottoPrice();
        ArrayList<Lotto> purchasedLottos = lottoMachine.creatLotto(price);
        view.outputPurchaseLotto(price, purchasedLottos);
        int[] winningNumbers = view.inputWinningNumbers();
        int bonus = view.inputBonusNumber();
        LottoRank rank = lottoMachine.checkLottoRank(purchasedLottos, winningNumbers, bonus);

    }
    public void initialize(LView view, LottoMachine lottoMachine) {
        this.view = view;
        this.lottoMachine = lottoMachine;
    }

}
