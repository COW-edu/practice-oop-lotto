package kr.abins.lotto.controller;

import kr.abins.lotto.Constants;
import kr.abins.lotto.model.Lotto;
import kr.abins.lotto.model.LottoPrize;
import kr.abins.lotto.model.LottoRecipe;
import kr.abins.lotto.model.LottoSession;
import kr.abins.lotto.view.LottoWriter;
import kr.abins.lotto.view.LottoReader;

import java.util.*;

public class LottoProcessor {

    private final LottoSession session;
    private final Map<LottoPrize, List<LottoRecipe>> recipes = new HashMap<>();

    public LottoProcessor(final LottoSession session) {
        this.session = session;
    }

    public void start() {
        this.readPurchaseAmount();

        this.generateLottos();

        this.readWinningNumber();
        this.readBonusNumber();

        this.matchLotto();
    }

    private int lottoCount() {
        return this.session.purchaseAmount() / Constants.LOTTO_PRICE;
    }

    public void generateLottos() {
        final int count = this.lottoCount();
        final LottoGenerator generator = new LottoGenerator(this.session);
        generator.generate(count);
    }

    public void matchLotto() {
        final LottoMatcher matcher = new LottoMatcher(this.session, this);
        matcher.matchLotto();
    }

    public void readBonusNumber() {
        LottoWriter.printBonusNumberMessage();
        this.session.bonus(LottoReader.readBonusNumber());
        LottoReader.validateBonusNumber(this.session.bonus(), this.session.winningNumbers());
    }

    public void readWinningNumber() {
        LottoWriter.printWinningNumbersMessage();
        this.session.winningNumbers(LottoReader.readWinningNumbers());
    }

    private void readPurchaseAmount() {
        LottoWriter.printPurchaseAmountMessage();
        this.session.purchaseAmount(LottoReader.readPurchaseAmount());
    }

    public Map<LottoPrize, List<LottoRecipe>> recipes() {
        return this.recipes;
    }
}
