package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private LottoMaker lottoMaker;
    public LottoSeller() {
        this.lottoMaker = new LottoMaker();
    }
    public List<Lotto> buyLottoes(String amount) {
        int lottoAmount = calculateLottoAmount(amount);
        List<Lotto> lottoes = new ArrayList<Lotto>();
        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = lottoMaker.makeLotto(Console.readLine());
            lottoes.add(lotto);
        }
        return lottoes;
    }
    private int calculateLottoAmount(String amount) {
        int lottoAmount = checkIsNumber(amount);
        if (lottoAmount % 1000 == 0) {
            return lottoAmount / 1000;
        }
        throw new IllegalArgumentException();
    }
    private int checkIsNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
