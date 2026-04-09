package kr.abins.lotto.controller;

import kr.abins.lotto.model.Lotto;
import kr.abins.lotto.model.LottoResult;
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
        final List<Lotto> lottos = this.generator.generate();

        final List<Integer> winningNumber = this.readWinningNumber();
        final int bonus = this.readBonusNumber();
        final WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumber), bonus);

        return LottoResult.generate(winningLotto, lottos);
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
