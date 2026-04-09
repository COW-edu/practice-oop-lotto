package kr.abins.lotto.model;

import kr.abins.lotto.constant.Constants;
import kr.abins.lotto.constant.ErrorMessage;

import java.util.Optional;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(final Lotto lotto, final int bonus) {
        if (bonus < Constants.MIN_LOTTO_NUMBER || bonus > Constants.MAX_LOTTO_NUMBER) {
            ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.throwSelf();
        }
        if (lotto.numbers().contains(bonus)) {
            ErrorMessage.BONUS_NUMBER_DUPLICATED.throwSelf();
        }

        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Optional<LottoPrize> match(final Lotto purchasedLotto) {
        int correct = (int) purchasedLotto.numbers().stream()
                .filter(this.lotto.numbers()::contains)
                .count();
        boolean bonusMatch = purchasedLotto.numbers().contains(this.bonus);

        return LottoPrize.find(correct, bonusMatch);
    }

    public Lotto lotto() {
        return this.lotto;
    }

    public int bonus() {
        return this.bonus;
    }
}
