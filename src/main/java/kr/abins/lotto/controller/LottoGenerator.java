package kr.abins.lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import kr.abins.lotto.constant.Constants;
import kr.abins.lotto.model.Lotto;
import kr.abins.lotto.model.PurchaseAmount;
import kr.abins.lotto.view.LottoReader;
import kr.abins.lotto.view.LottoWriter;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generate(final PurchaseAmount amount) {
        final int count = amount.lottoCount();

        final List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < count; index++) {

            final Lotto lotto = Lotto.generateRandom();
            lottos.add(lotto);
        }

        return lottos;
    }
}
