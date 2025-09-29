package Domain;

import java.util.Map;
import java.util.HashMap;

public class LottoResult {
    private Map<Rank, Integer> ranks;


    public LottoResult(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public int getYield() {
        int totalMoney = 0;
        for(Rank rank : ranks.keySet()) {
            totalMoney += rank.getPrizeMoney() * ranks.get(rank);
        }
        return totalMoney;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    public double calculateYield(int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return (double) getYield() / purchaseAmount * 100;
    }

}
