package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;
    private final Map<Rank, Integer> results;

    public LottoResult(List<Lotto> userLottos, WinningLotto winningLotto) {
        this.results = new EnumMap<>(Rank.class);
        initResults();
        calculateResults(userLottos, winningLotto);
    }

    private void initResults() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    private void calculateResults(List<Lotto> userLottos, WinningLotto winningLotto) {
        for (Lotto userLotto : userLottos) {
            Rank rank = winningLotto.match(userLotto);
            results.put(rank, results.get(rank) + 1);
        }
    }

    public double calculateYield() {
        long totalPrize = getTotalPrize();
        int totalPurchaseAmount = getTotalPurchaseAmount();

        // 수익률 = (총 당첨금 / 총 구입 금액) * 100
        return ((double) totalPrize / totalPurchaseAmount) * 100;
    }

    private long getTotalPrize() {
        return results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    private int getTotalPurchaseAmount() {
        int totalLottoCount = results.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        return totalLottoCount * LOTTO_PRICE;
    }

    // View에서 출력할 수 있도록 결과를 반환 (외부에서 수정할 수 없도록 UnmodifiableMap 사용)
    public Map<Rank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }
}