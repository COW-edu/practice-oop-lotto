package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoResult compareLottoNumbers(List<List<Integer>> lottoNumbers, int bonusNumber, int purchaseAmount) {
        Map<Integer, Integer> results = calculateResults(lottoNumbers, bonusNumber);
        double profitRate = calculateProfitRate(results, purchaseAmount);
        return new LottoResult(results, profitRate);
    }

    private Map<Integer, Integer> calculateResults(List<List<Integer>> lottoNumbers, int bonusNumber) {
        Map<Integer, Integer> result = new HashMap<>();

        for (List<Integer> lotto : lottoNumbers) {
            int matchCount = 0;
            for (int num : lotto) {
                if (numbers.contains(num)) {matchCount++;}}

            boolean bonusMatch = lotto.contains(bonusNumber);
            int rank = rankDetermine(matchCount, bonusMatch);

            if (rank > 0) {result.put(rank, result.getOrDefault(rank, 0) + 1);}
        }

        return result;
    }

    private double calculateProfitRate(Map<Integer, Integer> result, int purchaseAmount) {
        long totalPrize = 0;

        if (result.containsKey(1)) totalPrize += 2000000000L * result.get(1);
        if (result.containsKey(2)) totalPrize += 30000000L * result.get(2);
        if (result.containsKey(3)) totalPrize += 1500000L * result.get(3);
        if (result.containsKey(4)) totalPrize += 50000L * result.get(4);
        if (result.containsKey(5)) totalPrize += 5000L * result.get(5);

        return ((double) totalPrize / purchaseAmount) * 100;
    }

    private int rankDetermine(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return 1;
        if (matchCount == 5 && bonusMatch) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return 0;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {throw new IllegalArgumentException(ErrorMessage.INVALID_WIN_NUMBER_FORMAT);}
    }
}
