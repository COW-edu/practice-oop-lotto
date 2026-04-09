package kr.abins.lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import kr.abins.lotto.constant.Constants;
import kr.abins.lotto.model.Lotto;
import kr.abins.lotto.model.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generate(final PurchaseAmount amount) {
        final int count = amount.lottoCount();

        final List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < count; index++) {

            final Lotto lotto = this.generateRandom();
            lottos.add(lotto);
        }

        return lottos;
    }

    public Lotto generateRandom() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
            Constants.MIN_LOTTO_NUMBER,
            Constants.MAX_LOTTO_NUMBER,
            Constants.LOTTO_NUMBER_COUNT
        );

        return new Lotto(numbers);
    }
}
