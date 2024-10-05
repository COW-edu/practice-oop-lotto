package lotto;

import java.util.List;

public class ResultCalculator {
    private static final int MATCH_THREE = 3;
    private static final int MATCH_FOUR = 4;
    private static final int MATCH_FIVE = 5;
    private static final int MATCH_SIX = 6;
    private static final int MATCH_FIVE_BONUS = 7; // 5개 + 보너스 일치

    private void incrementCount(int[] matchCounts, int index) {
        if (index >= 0) {
            matchCounts[index]++;
        }
    }

    private int getMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    private int calculateResultIndex(int matchCount, boolean bonusMatch) {
        if (matchCount == MATCH_SIX) {return MATCH_SIX; // 6개 일치
        } if (matchCount == MATCH_FIVE && bonusMatch) {return MATCH_FIVE_BONUS; // 5개 + 보너스 일치
        } if (matchCount == MATCH_FIVE) {return MATCH_FIVE; // 5개 일치
        } if (matchCount == MATCH_FOUR) {return MATCH_FOUR; // 4개 일치
        } if (matchCount == MATCH_THREE) {return MATCH_THREE; // 3개 일치
        }return -1; // 일치하지 않는 경우

    }

    public int[] calculateResults(List<Lotto> boughtLottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[8];

        for (Lotto lotto : boughtLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            int resultIndex = calculateResultIndex(matchCount, bonusMatch);
            incrementCount(matchCounts, resultIndex);
        }
        return matchCounts;
    }
}
