package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void compareLottoNumbers(List<List<Integer>> lottoNumbers, int bonusNumber, int purchaseAmount) {
        printMessage();
        Map<Integer, Integer> results = calculateResults(lottoNumbers, bonusNumber);
        printResults(results);
        printProfitRate(results, purchaseAmount);
    }

    private Map<Integer, Integer> calculateResults(List<List<Integer>> lottoNumbers, int bonusNumber) {
        Map<Integer, Integer> result = new HashMap<>();

        for (List<Integer> lotto : lottoNumbers) {
            int matchCount = 0;
            for (int num : lotto) {
                if (numbers.contains(num)) {
                    matchCount++;
                }
            }

            boolean bonusMatch = lotto.contains(bonusNumber);
            int rank = rankDetermine(matchCount, bonusMatch);

            if (rank > 0) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }

        return result;
    }

    private void printResults(Map<Integer, Integer> result) {
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(5, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(3, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault(2, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(1, 0) + "개");
    }

    private void printProfitRate(Map<Integer, Integer> result, int purchaseAmount) {
        long totalPrize = 0;

        if (result.containsKey(1)) {totalPrize += (long) 2000000000 * result.get(1);}
        if (result.containsKey(2)) {totalPrize += (long) 30000000 * result.get(2);}
        if (result.containsKey(3)) {totalPrize += (long) 1500000 * result.get(3);}
        if (result.containsKey(4)) {totalPrize += (long) 50000 * result.get(4);}
        if (result.containsKey(5)) {totalPrize += (long) 5000 * result.get(5);}

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private int rankDetermine(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return 1;
        if (matchCount == 5 && bonusMatch) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return 0;
    }

    private void printMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }
}
