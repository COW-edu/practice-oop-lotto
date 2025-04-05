package lotto;

import java.util.*;

public class LottoResult {
    private final Map<Integer, Integer> resultMap = new HashMap<>();

    public LottoResult(LottoTicket ticket, WinningLotto winningLotto) {
        for (LottoDraws lotto : ticket.getLottos()) {
            int matchCount = countMatchingNumbers(lotto, winningLotto.getLotto());
            boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());
            updateResult(matchCount, bonusMatch);
        }
    }

    private int countMatchingNumbers(LottoDraws lotto, LottoDraws winningLotto) {
        return (int) lotto.getNumbers().stream().filter(winningLotto.getNumbers()::contains).count();
    }

    private void updateResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            resultMap.put(1, resultMap.getOrDefault(1, 0) + 1);
        } else if (matchCount == 5 && bonusMatch) {
            resultMap.put(2, resultMap.getOrDefault(2, 0) + 1);
        } else if (matchCount == 5) {
            resultMap.put(3, resultMap.getOrDefault(3, 0) + 1);
        } else if (matchCount == 4) {
            resultMap.put(4, resultMap.getOrDefault(4, 0) + 1);
        } else if (matchCount == 3) {
            resultMap.put(5, resultMap.getOrDefault(5, 0) + 1);
        }
    }

    public void printResults(int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int totalPrize = 0;
        int[] prizeMoney = {5000, 50000, 1500000, 30000000, 2000000000};
        String[] messages = {
                "3개 일치 (5,000원) - ",
                "4개 일치 (50,000원) - ",
                "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                "6개 일치 (2,000,000,000원) - "
        };

        for (int i = 0; i < messages.length; i++) {
            int count;
            if (i == 4) {
                count = resultMap.getOrDefault(1, 0);
            } else {
                count = resultMap.getOrDefault(i + 3, 0);
            }

            System.out.println(messages[i] + count + "개");
            totalPrize += count * prizeMoney[i];
        }

        double profit = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}