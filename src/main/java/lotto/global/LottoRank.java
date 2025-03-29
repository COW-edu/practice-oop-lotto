package lotto.global;

public enum LottoRank {

    FIFTH(3,false,5000, "3개 일치 (5,000원)"),
    FOURTH(4,false,50000, "4개 일치 (50,000원)"),
    THIRD(5,false,1500000, "5개 일치 (1,500,000원)"),
    SECOND(5,true,30000000, "5개, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6,false,2000000000, "6개 일치 (200,000,000원)");

    private final int count;
    private final boolean bonus;
    private final int prize;
    private final String prizeText;

    
    LottoRank(int count, boolean bonus,int prize, String prizeText) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
        this.prizeText = prizeText;
    }
    
    public static LottoRank valueOf(int count, boolean bonus) {
        if(count== SECOND.count && bonus == SECOND.bonus) {
            return SECOND;
        }
        for(LottoRank rank : values()) {
            if(rank.count == count) {
                return rank;
            }
        }
        return null;
    }

    public int getCount() {
        return count;
    }
    
    public int getPrize() {
        return prize;
    }

    public String getPrizeText() {
        return prizeText;
    }
}