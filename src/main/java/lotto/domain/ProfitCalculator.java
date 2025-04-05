package lotto.domain;

import lotto.constant.LottoPrize;

import java.util.Map;

public class ProfitCalculator {
    private final int purchaseAmount;
    private final Map<LottoPrize, Integer> winningResults;

    public ProfitCalculator(int purchaseAmount, Map<LottoPrize, Integer> winningResults) {
        this.purchaseAmount = purchaseAmount;
        this.winningResults = winningResults;
    }

    public long calculateTotalProfit() {
        long totalProfit = 0;
        for (LottoPrize prize : winningResults.keySet()) {
            Integer count = winningResults.get(prize);
            if (prize != null && count != null) {
                totalProfit += (long) prize.getPrizeAmount() * count;
            }
        }
        return totalProfit;
    }

    public double calculateProfitRate() {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        double profitRate = (double) calculateTotalProfit() / purchaseAmount * 100;
        return Math.round(profitRate * 100.0) / 100.0;
    }
}