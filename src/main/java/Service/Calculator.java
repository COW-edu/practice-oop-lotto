package Service;

import Entity.Lotto;
import Entity.Prize;
import Entity.WinningNum;

import java.util.ArrayList;
import java.util.List;

import static Entity.Prize.*;

public class Calculator {

    public List<Prize> calculateResult(List<Lotto> purchasedLottoList, int bonusNumber) {
        List<Prize> prizeList = new ArrayList<>();

        for (Lotto lotto : purchasedLottoList) {
            int matchCount = countMatchedNumbers(lotto, WinningNum.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Prize prize = Prize.calculatePrize(matchCount, bonusMatch);
            prizeList.add(prize);
            prize.increaseCount();
        }

        return prizeList;
    }

    public int[] setPrize(List<Prize> prizeList){
        int[] matchingCounts = new int[WIN_SECOND_PRIZE+1];

        for (Prize prize : prizeList) {
            int matchCount = prize.getMatchCount();
            int winnersCount = prize.getWinnersCount();

            if (matchCount == WIN_THIRD_PRIZE && prize.isBonusNumMatch()) {
                matchingCounts[WIN_SECOND_PRIZE] += winnersCount;
            } else {
                matchingCounts[matchCount] += winnersCount;
            }
        }
        return matchingCounts;
    }

    public double calculateProfit(List<Prize> prizeList, int totalMoneySpent) {
        int totalPrizeMoney = prizeList.stream()
                .mapToInt(Prize::getPrizeMoney)
                .sum();

        return totalPrizeMoney / totalMoneySpent * 100.0;
    }

    private int countMatchedNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
