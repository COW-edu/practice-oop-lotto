package kr.abins.lotto.controller;

import kr.abins.lotto.model.Lotto;
import kr.abins.lotto.model.LottoResult;
import kr.abins.lotto.model.PurchaseAmount;
import kr.abins.lotto.model.WinningLotto;
import kr.abins.lotto.view.LottoReader;
import kr.abins.lotto.view.LottoWriter;

import java.util.List;

public class LottoProcessor {

    private final LottoReader reader;
    private final LottoWriter writer;
    private final LottoGenerator generator;

    public LottoProcessor(final LottoReader reader, final LottoWriter writer, final LottoGenerator generator) {
        this.reader = reader;
        this.writer = writer;
        this.generator = generator;
    }

    public LottoResult start() {

        final PurchaseAmount purchaseAmount = this.readPurchaseAmount();
        this.writer.printNewLine();
        this.writer.printPurchaseCount(purchaseAmount.lottoCount());
        // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        final List<Lotto> lottos = this.generator.generate(purchaseAmount);
        for (final Lotto lotto : lottos) {
            this.writer.printLottoNumbers(lotto.numbers());
        }
        // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        final List<Integer> winningNumber = this.readWinningNumber();
        final int bonus = this.readBonusNumber();
        final WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumber), bonus);

        return LottoResult.generate(winningLotto, lottos);
    }


    private PurchaseAmount readPurchaseAmount() {
        this.writer.printPurchaseAmountMessage();
        return new PurchaseAmount(this.reader.readPurchaseAmount());
    }

    private int readBonusNumber() {
        this.writer.printBonusNumberMessage();
        return this.reader.readBonusNumber();
    }

    private List<Integer> readWinningNumber() {
        this.writer.printWinningNumbersMessage();
        return this.reader.readWinningNumbers();
    }
}
