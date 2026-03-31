package kr.abins.lotto.model;

import kr.abins.lotto.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum LottoPrize {

    PRIZE_1ST(Constants.PRIZE_1ST, 6, false),
    PRIZE_2ND(Constants.PRIZE_2ND, 5, true),
    PRIZE_3RD(Constants.PRIZE_3RD, 5, false),
    PRIZE_4TH(Constants.PRIZE_4TH, 4, false),
    PRIZE_5TH(Constants.PRIZE_5TH, 3, false);


    public static Optional<LottoPrize> find(final List<Integer> winningNumber, final int bonus, final Lotto lotto) {
        final int correct = lotto.correct(winningNumber);
        final boolean bonusMatch = lotto.bonusMatch(bonus);

        return Arrays.stream(LottoPrize.values())
            .filter(prize -> prize.correct == correct)
            .filter(prize -> {
                if (prize.correct == 5) {
                    return prize.correctBonus == bonusMatch;
                }
                return true;
            })
            .findFirst();
    }

    private static List<LottoPrize> candidates(final int correct) {
        return Arrays.stream(LottoPrize.values())
            .filter(prize -> prize.correct == correct)
            .collect(Collectors.toList());
    }

    private final long prizeMoney;
    private final int correct;
    private final boolean correctBonus;

    LottoPrize(final long prizeMoney, int correct, boolean correctBonus) {
        this.prizeMoney = prizeMoney;
        this.correct = correct;
        this.correctBonus = correctBonus;
    }

    public long prizeMoney() {
        return this.prizeMoney;
    }
    
    public int corrects() {
        return this.correct;
    }
    
    public boolean correctBonus() {
        return this.correctBonus;
    }
}
