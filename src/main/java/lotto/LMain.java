package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LMain {
    private LView view;
    private LottoMachine lottoMachine;
    private ArrayList<Lotto> purchasedLottos;


    public LMain() {

    }
    public void start() {
        view.inputLottoPrice();

    }
    public void initialize(LView view) {
        this.view = view;
    }

}
