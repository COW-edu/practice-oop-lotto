package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private LottoMaker lottoMaker;
    public LottoSeller() {
        this.lottoMaker = new LottoMaker();
    }
    public List<Lotto> buyLottoes(String amount) {
        int lottoAmount = calculateLottoAmount(amount);
        if(lottoAmount > 0) {
            List<Lotto> lottoes = new ArrayList<Lotto>();
            for (int i = 0; i < lottoAmount; i++) {
                Lotto lotto = lottoMaker.makeLotto();
                lottoes.add(lotto);
            }
            return lottoes;
        }
        throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다");
    }
    private int calculateLottoAmount(String amount) {
        int lottoAmount = checkIsNumber(amount);
        if (lottoAmount % 1000 == 0) {
            return lottoAmount / 1000;
        }
        throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다");
    }
    private int checkIsNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
