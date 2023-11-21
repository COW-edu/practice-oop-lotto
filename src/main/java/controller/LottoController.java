package controller;

import lotto.Lotto;

import java.util.List;

import lotto.RandomLotto;

public class LottoController {

    private List<Lotto> lottos;

    public LottoController() {

    }

    public List<Lotto> makeRandomLottos(RandomLotto randomLotto, int count) {
        lottos = randomLotto.makeList(count);
        return lottos;
    }

}
