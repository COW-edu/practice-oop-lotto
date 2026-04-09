package kr.abins.lotto.model;

import kr.abins.lotto.constant.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoPrize, Integer> prizeCounts;
    private final int purchaseAmount;
    private final double profitRate;

    public LottoResult(final Map<LottoPrize, List<LottoReceipt>> recipes) {
        this.prizeCounts = recipes.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
        this.purchaseAmount = recipes.values().stream().mapToInt(List::size).sum() * Constants.LOTTO_PRICE;

        this.profitRate = this.calculateProfitRate();
    }

    public static LottoResult generate(final WinningLotto winningLotto, final List<Lotto> lottos) {
        final Map<LottoPrize, List<LottoReceipt>> recipes = new HashMap<>();
        for (final Lotto lotto : lottos) {
            final Optional<LottoPrize> prize = winningLotto.match(lotto);
            prize.ifPresent(p -> recipes.computeIfAbsent(p, k -> new ArrayList<>()).add(new LottoReceipt(lotto, p)));
        }

        return new LottoResult(recipes);
    }

    public int count(LottoPrize prize) {
        return this.prizeCounts.getOrDefault(prize, 0);
    }

    public double profitRate() {
        return this.profitRate;
    }

    private double calculateProfitRate() {
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
