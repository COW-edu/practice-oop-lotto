package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public LottoStatistics() {
        initialize();
    }

    public void add(Rank rank) {
        if (rank == Rank.MISS) {
            return;
        }
        counts.put(rank, counts.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return counts.get(rank);
    }

    public long calculateTotalPrize() {
        long totalPrize = 0L;
        for (Rank rank : Rank.winningRanks()) {
            totalPrize += (long) rank.getPrize() * getCount(rank);
        }
        return totalPrize;
    }

    public double calculateProfitRate(int purchaseAmount) {
        return (double) calculateTotalPrize() / purchaseAmount * 100;
    }

    private void initialize() {
        for (Rank rank : Rank.winningRanks()) {
            counts.put(rank, 0);
        }
    }
}
