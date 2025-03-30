package lotto;

import model.Lotto;
import model.LottoRank;
import view.View;

import java.util.ArrayList;


public class MainSystem {
    private View view;
    private LottoMachine lottoMachine;

    public MainSystem() {

    }
    public void start() {
        int price = view.inputLottoPrice();
        ArrayList<Lotto> purchasedLottos = lottoMachine.creatLotto(price);
        view.outputPurchaseLotto(price, purchasedLottos);
        int[] winningNumbers = view.inputWinningNumbers();
        int bonus = view.inputBonusNumber(winningNumbers);
        LottoRank rank = lottoMachine.checkLottoRank(purchasedLottos, winningNumbers, bonus);
        view.outputWinningCount(rank);
        view.outputprofitRate(price, rank.getTotalPrizeMoney());
    }
    public void initialize(View view, LottoMachine lottoMachine) {
        this.view = view;
        this.lottoMachine = lottoMachine;
    }
}
