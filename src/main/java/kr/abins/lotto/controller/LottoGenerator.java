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

    private final LottoReader reader;
    private final LottoWriter writer;

    public LottoGenerator(final LottoReader reader, final LottoWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<Lotto> generate() {
        final PurchaseAmount amount = this.readPurchaseAmount();
        final int count = amount.lottoCount();
        this.writer.printNewLine();
        this.writer.printPurchaseCount(count);

        final List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            final List<Integer> randomNumbers = this.pickRandomNumbers();
            this.writer.printLottoNumbers(randomNumbers);

            final Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private PurchaseAmount readPurchaseAmount() {
        this.writer.printPurchaseAmountMessage();
        return new PurchaseAmount(this.reader.readPurchaseAmount());
    }

    private List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.MIN_LOTTO_NUMBER,
                Constants.MAX_LOTTO_NUMBER,
                Constants.LOTTO_NUMBER_COUNT
        );
    }
}
