// 3주차 코드입니다 2주차로 잘못올려서 다시올립니다 ㅜㅜ

package constant;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    NONE(0, 0, "");

    private final int matchCount;
    private final int prizeMoney;
    private final String resultMessage;

    LottoRank(int matchCount, int prizeMoney, String resultMessage) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.resultMessage = resultMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public static int[] getRankNumbers() {
        return new int[LottoRank.values().length];
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == FIRST.getMatchCount()) {
            return FIRST;
        }
        if (matchCount == SECOND.getMatchCount() && matchBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.getMatchCount()) {
            return THIRD;
        }
        if (matchCount == FOURTH.getMatchCount()) {
            return FOURTH;
        }
        if (matchCount == FIFTH.getMatchCount()) {
            return FIFTH;
        }
        return NONE;
    }
}
