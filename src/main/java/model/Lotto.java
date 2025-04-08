package model;

import lotto.ErrorMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
}

public LottoResult compareDigits(List<List<Integer>> lottoDigits, int bonus, int money) {
    Map<Integer, Integer> result = new HashMap<>();
    for (List<Integer> lottoDigit : lottoDigits) {
        int matchCount = 0;
        for (int num : lottoDigit) {
            if (numbers.contains(num)) {
                matchCount++;
            }
        }
        boolean bonusMatch = lottoDigit.contains(bonus);
        int rank = getRank(matchCount, bonusMatch);
        if (rank > 0) result.put(rank, result.getOrDefault(rank, 0) + 1);
    }
    double profit = calculateProfitRate(result, money);
    return new LottoResult(result,profit,money);
}

    private int getRank(int match, boolean bonus) {
        if (match == 6) return 1;
        if (match == 5 && bonus) return 2;
        if (match == 5) return 3;
        if (match == 4) return 4;
        if (match == 3) return 5;
        return 0;
}

    private double calculateProfitRate(Map<Integer, Integer> result, int money) {
        long total = 0;
        total += result.getOrDefault(1, 0) * 2_000_000_000L;
        total += result.getOrDefault(2, 0) * 30_000_000L;
        total += result.getOrDefault(3, 0) * 1_500_000L;
        total += result.getOrDefault(4, 0) * 50_000L;
        total += result.getOrDefault(5, 0) * 5_000L;
        return ((double) total / money) * 100;
}
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WIN_NUMBER_FORMAT);
        }
}
}