package enums;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000,false),
    FOURTH(4, 50_000,false),
    FIFTH(3, 5_000,false),
    MISS(0, 0,false);

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;

    Rank(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }
    public static Rank of(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {return FIRST;}
        if (matchCount == 5 && matchBonus) {return SECOND;}
        if (matchCount == 5) {return THIRD;}
        if (matchCount == 4) {return FOURTH;}
        if (matchCount == 3) {return FIFTH;}
        return MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
    public boolean isMatchBonus() {
        return matchBonus;
    }

    public String getDisplayString() {
        if (this == FIRST) return "6개 일치 (2,000,000,000원) - ";
        if (this == SECOND) return "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        if (this == THIRD) return "5개 일치 (1,500,000원) - ";
        if (this == FOURTH) return "4개 일치 (50,000원) - ";
        if (this == FIFTH) return "3개 일치 (5,000원) - ";
        return "";
    }
}
