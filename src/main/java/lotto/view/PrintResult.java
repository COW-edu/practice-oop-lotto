package lotto.view;

import java.util.Map;

public class PrintResult {
    public PrintResult(Map<String, Integer> results, int purchaseAmount) {
        int totalPrize = 0;
        int[] prizeMoney = {5000, 50000, 1500000, 30000000, 2000000000};
        String[] messages = {
                "3개 일치 (5,000원) - ",
                "4개 일치 (50,000원) - ",
                "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                "6개 일치 (2,000,000,000원) - "
        };
        String[] keys = {"3", "4", "5", "5+bonus", "6"};

        for (int i = 0; i < messages.length; i++) {
            int count = results.get(keys[i]);
            System.out.println(messages[i] + count + "개");
            totalPrize += count * prizeMoney[i];
        }

        double profit = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}