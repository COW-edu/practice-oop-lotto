package controller;

import model.CalculateSheet;
import model.Lotto;
import view.VLotto;

public class CLotto {
    private CalculateSheet calculateSheet;
    private VLotto vLotto;

    public CLotto(CalculateSheet calculateSheet, VLotto vLotto) {
        this.calculateSheet = calculateSheet;
        this.vLotto = vLotto;
    }

    public void run() {
        int money = vLotto.getMoneyInput();
        int lottoCount = calculateSheet.buyLotto(money);
        vLotto.displayLottoCount(lottoCount);
    }
}
