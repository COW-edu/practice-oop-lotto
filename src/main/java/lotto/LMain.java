package lotto;

import java.util.ArrayList;
import java.util.List;


public class LMain {
    private LView view;
    private LottoMachine lottoMachine;
    private ArrayList<Lotto> purchasedLottos;


    public LMain() {

    }
    public void start() {
        int price = view.inputLottoPrice();
        ArrayList<Lotto> lottos = lottoMachine.creatLotto(price);
        view.outputPurchaseLotto(price, lottos);

    }
    public void initialize(LView view, LottoMachine lottoMachine) {
        this.view = view;
        this.lottoMachine = lottoMachine;
    }

}
