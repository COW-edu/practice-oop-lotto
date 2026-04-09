package kr.abins.lotto.model;

import kr.abins.lotto.constant.Constants;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public enum LottoPrize {

    PRIZE_1ST(Constants.PRIZE_1ST, 6, false),
    PRIZE_2ND(Constants.PRIZE_2ND, 5, true),
    PRIZE_3RD(Constants.PRIZE_3RD, 5, false),
    PRIZE_4TH(Constants.PRIZE_4TH, 4, false),
    PRIZE_5TH(Constants.PRIZE_5TH, 3, false),
    NONE_2(0, 2, false),
    NONE_1(0, 1, false),
    NONE_0(0, 0, false);

    private final long prizeMoney;
    private final int correct;
    private final boolean correctBonus;

    LottoPrize(final long prizeMoney, int correct, boolean correctBonus) {
        this.prizeMoney = prizeMoney;
        this.correct = correct;
        this.correctBonus = correctBonus;
    }

    public boolean isWinning() {
        return this.prizeMoney > 0;
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

    public static Optional<LottoPrize> find(final int correct, final boolean bonusMatch) {
        final Stream<LottoPrize> candidates = candidates(correct);

        return candidates
                .filter(prize -> matchesBonus(prize, bonusMatch))
                .findFirst();
    }

    private static boolean matchesBonus(LottoPrize prize, boolean bonusMatch) {
        if (prize.correct != 5) return true;
        return prize.correctBonus == bonusMatch;
    }

    private static Stream<LottoPrize> candidates(final int correct) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.correct == correct);
    }
}
