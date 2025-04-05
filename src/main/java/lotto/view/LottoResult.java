package lotto.view;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    public LottoResult(int matchCount, boolean bonusMatch, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<String, Integer> results = new HashMap<>();
        results.put("3", 0);
        results.put("4", 0);
        results.put("5", 0);
        results.put("5+bonus", 0);
        results.put("6", 0);

        if (matchCount == 6) { results.put("6", results.get("6") + 1); }
        if (matchCount == 5 && bonusMatch) { results.put("5+bonus", results.get("5+bonus") + 1); }
        if (matchCount == 5) { results.put("5", results.get("5") + 1); }
        if (matchCount == 4) { results.put("4", results.get("4") + 1); }
        if (matchCount == 3) { results.put("3", results.get("3") + 1); }

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