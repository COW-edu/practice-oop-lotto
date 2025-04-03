package domain.calculator;

import model.WinningRank;

import java.util.Map;

public class ProfitCalculator {
    public static float calculate(Map<WinningRank, Integer> winningResult, int purchaseAmount) {
        int totalPrize = winningResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        float profitRate = (float) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0f;
    }
}
