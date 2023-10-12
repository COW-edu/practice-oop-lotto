package controller;

import model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    private LottoFactory lottoFactory;

    public LottoSeller() {
        this.lottoFactory = new LottoFactory();
    }

    public List<Lotto> buyLottos(int amount) {
        int lottoAmount = calculateLottoAmount(amount);
        List<Lotto> lottos = new ArrayList<Lotto>(lottoAmount);

        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = lottoFactory.makeLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private int calculateLottoAmount(int amount) {
        return amount / LOTTO_PRICE;
    }
}
