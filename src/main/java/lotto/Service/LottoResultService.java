package lotto.Service;

import lotto.Model.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultService {

    public Map<Rank, Integer> calculate(
            List<List<Integer>> lottos,
            List<Integer> winningNumbers,
            int bonusNum) {

        Map<Rank, Integer> result = new HashMap<>();

        for (List<Integer> lotto : lottos) {
            int matchCount = (int) lotto.stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = lotto.contains(bonusNum);
            Rank rank = Rank.of(matchCount, bonusMatch);

            if (rank != Rank.MISS) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }

        return result;
    }

    public double calculateProfitRate(Map<Rank, Integer> result, int purchaseAmount) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            totalPrize += (long) entry.getKey().getPrize() * entry.getValue();
        }
        return (double) totalPrize / purchaseAmount * 100;
    }
}