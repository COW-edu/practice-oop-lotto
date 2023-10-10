package Model;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static List<Prize> calculateResult(List<Lotto> purchasedLottoList, WinningNum winningNum, int bonusNumber) {
        List<Prize> prizeList = new ArrayList<>();

        for (Lotto lotto : purchasedLottoList) {
            int matchCount = countMatchedNumbers(lotto, winningNum.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Prize prize = Prize.calculatePrize(matchCount, bonusMatch);
            prizeList.add(prize);
            prize.increaseCount();
        }

        return prizeList;
    }

    public static double calculateProfit(List<Prize> prizeList, int totalMoneySpent) {
        int totalPrizeMoney = prizeList.stream()
                .mapToInt(Prize::getPrizeMoney)
                .sum();

        return (double) totalPrizeMoney / totalMoneySpent * 100;
    }

    private static int countMatchedNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
