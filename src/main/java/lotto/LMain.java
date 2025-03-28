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

    }
    public void initialize(LView view) {
        this.view = view;
    }

}
