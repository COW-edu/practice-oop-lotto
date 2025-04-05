package lotto.global;

import java.util.Optional;

public enum LottoRank {

    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000, "5개, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 200_000_000, "6개 일치 (200,000,000원)");

    private final int matchCount;
    private final boolean bonus;
    private final int prize;
    private final String prizeText;


    LottoRank(int matchCount, boolean bonus, int prize, String prizeText) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
        this.prizeText = prizeText;
    }

    public static Optional<LottoRank> valueOf(int matchCount, boolean bonus) {
        if (matchCount == SECOND.matchCount && bonus == SECOND.bonus) {
            return Optional.of(SECOND);
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount) {
                return Optional.of(rank);
            }
        }
        return Optional.empty();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrizeText() {
        return prizeText;
    }
}




