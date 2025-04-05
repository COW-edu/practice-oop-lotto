package model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results;
    private final int totalPurchasePrice;

    public LottoResult(LottoTickets purchasedLottos, WinningLotto winningLotto, int totalPurchasePrice) {
        this.results = initializeResults();
        this.totalPurchasePrice = totalPurchasePrice;
        calculateResults(purchasedLottos, winningLotto);
    }

    private Map<Rank, Integer> initializeResults() {
        Map<Rank, Integer> initialResults = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            initialResults.put(rank, 0);
        }
        return initialResults;
    }

    //결과 계산
    private void calculateResults(LottoTickets purchasedLottos, WinningLotto winningLotto) {
        for (Lotto lotto : purchasedLottos.getTickets()) {
            int matchCount = countMatchingNumbers(lotto, winningLotto.getWinningNumbers());
            boolean bonusMatch = checkBonusMatch(lotto, winningLotto.getBonusNumber());
            Rank rank = Rank.determineRank(matchCount, bonusMatch);

            int currentCount = results.get(rank);
            results.put(rank, currentCount + 1);
        }
    }

    //당첨 숫자 세기
    private int countMatchingNumbers(Lotto purchasedLotto, Lotto winningLotto) {
        int matchCount = 0;
        for (Integer number : purchasedLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean checkBonusMatch(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public Map<Rank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public int getTotalPurchasePrice() {
        return totalPurchasePrice;
    }

    public int calculateTotalWinnings() {
        int totalWinnings = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            totalWinnings += entry.getKey().getPrize() * entry.getValue();
        }
        return totalWinnings;
    }

    public double calculateProfitRate() {
        int totalWinnings = calculateTotalWinnings();
        double profitRate = ((double) totalWinnings / totalPurchasePrice) * 100.0;
        return Math.round(profitRate * 10.0) / 10.0;
    }
}