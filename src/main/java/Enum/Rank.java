package Enum;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    MISS(0, 0, ""), ;

    private int countMatch;
    private int reward;
    private String announce;

    Rank(int countMatch, int reward, String announce) {
        this.countMatch = countMatch;
        this.reward = reward;
        this.announce = announce;
}

    public int getCountMatch() {
        return this.countMatch;
    }

    public double getReward() {return this.reward;}

    public String getAnnounce() {
        return this.announce;
    }

}