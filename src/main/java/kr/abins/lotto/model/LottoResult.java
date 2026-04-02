package kr.abins.lotto.model;

import kr.abins.lotto.Constants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoPrize, Integer> prizeCounts;
    private final int purchaseAmount;

    public LottoResult(final Map<LottoPrize, List<LottoRecipe>> recipes) {
        this.prizeCounts = recipes.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
        this.purchaseAmount = recipes.values().stream().mapToInt(List::size).sum() * Constants.LOTTO_PRICE;
    }

    public int count(LottoPrize prize) {
        return this.prizeCounts.getOrDefault(prize, 0);
    }

    public double calculateProfitRate() {
        if (this.purchaseAmount == 0) {
            return 0;
        }

        final long totalPrizeMoney = this.calculateTotalPrizeMoney();
        return (((double) totalPrizeMoney) / this.purchaseAmount) * 100;
    }

    private long calculateTotalPrizeMoney() {
        long total = 0;
        for (final LottoPrize prize : LottoPrize.values()) {
            total += prize.prizeMoney() * this.count(prize);
        }

        return total;
    }
}
