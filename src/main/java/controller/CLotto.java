package controller;

import model.CalculateSheet;
import model.Lotto;
import view.VLotto;

import java.util.List;

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

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = calculateSheet.lottoNumbers();
            vLotto.displayLottoNumber(lottoNumbers);
        }
    }
}
