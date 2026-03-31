package kr.abins.lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> prizeCounts;
    private final int purchaseAmount;

    public LottoResult(Map<LottoPrize, List<LottoRecipe>> recipes, int purchaseAmount) {
        this.prizeCounts = new HashMap<>();
        for (LottoPrize prize : LottoPrize.values()) {
            this.prizeCounts.put(prize, recipes.getOrDefault(prize, List.of()).size());
        }
        this.purchaseAmount = purchaseAmount;
    }

    public int getCount(LottoPrize prize) {
        return prizeCounts.getOrDefault(prize, 0);
    }

    public double calculateProfitRate() {
        if (purchaseAmount == 0) {
            return 0;
        }
        long totalPrizeMoney = calculateTotalPrizeMoney();
        return (double) totalPrizeMoney / purchaseAmount * 100;
    }

    private long calculateTotalPrizeMoney() {
        long total = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            total += prize.prizeMoney() * getCount(prize);
        }
        return total;
    }
}
