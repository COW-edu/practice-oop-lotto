package lotto;

import java.util.List;

public class ResultCalculator {
    private static final int MATCH_THREE = 3;
    private static final int MATCH_FOUR = 4;
    private static final int MATCH_FIVE = 5;
    private static final int MATCH_SIX = 6;

    public int[] calculateResults(List<Lotto> boughtLottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[7];
        for (Lotto lotto : boughtLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            matchCounts[getResultIndex(matchCount, bonusMatch)]++;
        }
        return matchCounts;
    }

    private int getMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    private int getResultIndex(int matchCount, boolean bonusMatch) {
        if (matchCount == MATCH_SIX) return MATCH_SIX;
        if (matchCount == MATCH_FIVE && bonusMatch) return MATCH_FIVE + 1; // 보너스 번호 일치
        return matchCount;
    }
}
