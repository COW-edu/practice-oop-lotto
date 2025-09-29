package lotto.Domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchNum;
    private final int prizeMoney;

    private Rank(int matchNum, int prizeMoney) {
        this.matchNum = matchNum;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank valueOf(int matchNum, boolean matchBonus){
        if(matchNum == 6){
            return FIRST;
        }
        if(matchNum == 5 && matchBonus){
            return SECOND;
        }
        if(matchNum == 5){
            return THIRD;
        }
        if(matchNum == 4){
            return FOURTH;
        }
        if(matchNum == 3){
            return FIFTH;
        }
        return NONE;
    }
}
