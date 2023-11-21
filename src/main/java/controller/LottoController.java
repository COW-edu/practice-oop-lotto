package controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;

import lotto.RandomLotto;

public class LottoController {

    private List<Lotto> lottos;
    private Lotto selectLotto;

    public LottoController() {

    }

    public List<Lotto> makeRandomLottos(RandomLotto randomLotto, int count) {
        lottos = randomLotto.makeList(count);
        return lottos;
    }

    public Lotto makeCustomerLotto(List<Integer> selectLottoNumber) {
        this.selectLotto = new Lotto(selectLottoNumber);
        return selectLotto;
    }

}
