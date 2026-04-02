package kr.abins.lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import kr.abins.lotto.Constants;
import kr.abins.lotto.model.Lotto;
import kr.abins.lotto.model.LottoSession;
import kr.abins.lotto.view.LottoWriter;

import java.util.List;

public class LottoGenerator {

    private final LottoSession session;

    public LottoGenerator(final LottoSession session) {
        this.session = session;
    }

    public void generate(final int count) {
        LottoWriter.printNewLine();
        LottoWriter.printPurchaseCount(count);

        for (int index = 0; index < count; index++) {
            final List<Integer> randomNumbers = this.pickRandomNumbers();
            LottoWriter.printLottoNumbers(randomNumbers);

            final Lotto lotto = new Lotto(randomNumbers);
            this.session.lottos().add(lotto);
        }
    }

    public List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.MIN_LOTTO_NUMBER,
                Constants.MAX_LOTTO_NUMBER,
                Constants.LOTTO_NUMBER_COUNT
        );
    }
}
