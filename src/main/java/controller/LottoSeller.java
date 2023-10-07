package controller;

import model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private LottoMaker lottoMaker;

    public LottoSeller() {
        this.lottoMaker = new LottoMaker();
    }

    public List<Lotto> buyLottos(int amount) {
        int lottoAmount = calculateLottoAmount(amount);
        List<Lotto> lottos = new ArrayList<Lotto>();

        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = lottoMaker.makeLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private int calculateLottoAmount(int amount) {
        return amount / 1000;
    }
}
