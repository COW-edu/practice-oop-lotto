package kr.abins.lotto.controller;

import kr.abins.lotto.model.Lotto;
import kr.abins.lotto.model.LottoPrize;
import kr.abins.lotto.model.LottoRecipe;
import kr.abins.lotto.model.LottoSession;
import kr.abins.lotto.view.LottoWriter;

import java.util.ArrayList;
import java.util.Optional;

public class LottoMatcher {

    private final LottoSession session;
    private final LottoProcessor processor;

    public LottoMatcher(final LottoSession session, final LottoProcessor processor) {
        this.session = session;
        this.processor = processor;
    }

    public void matchLotto() {
        LottoWriter.printNewLine();
        for (final Lotto lotto : this.session.lottos()) {
            this.matchingLotto(lotto);
        }
    }

    private void matchingLotto(final Lotto lotto) {
        final Optional<LottoPrize> prizeOptional = LottoPrize.find(this.session.winningNumbers(), this.session.bonus(), lotto);
        prizeOptional.ifPresent(
            prize -> this.processor
                    .recipes()
                    .computeIfAbsent(prize, k -> new ArrayList<>())
                    .add(new LottoRecipe(lotto, prize))
        );
    }

}
