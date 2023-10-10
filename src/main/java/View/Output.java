package View;

import Model.Prize;

import java.util.List;

public class Output {
    public static void printResult(List<Prize> prizeList) {
        System.out.println("당첨 통계");
        System.out.println("---");

        final int MATCH_3_PRIZE = 3;
        final int MATCH_4_PRIZE = 4;
        final int MATCH_5_PRIZE = 5;
        final int MATCH_6_PRIZE = 6;
        final int MATCH_5_PRIZE_BONUS = 7;


        int[] matchingCounts = new int[MATCH_5_PRIZE_BONUS+1];

        for (Prize prize : prizeList) {
            int matchCount = prize.getMatchCount();
            int winnersCount = prize.getWinnersCount();

            if (matchCount == MATCH_5_PRIZE && prize.isBonusNumMatch()) {
                matchingCounts[MATCH_5_PRIZE_BONUS] += winnersCount;
            } else {
                matchingCounts[matchCount] += winnersCount;
            }
        }

        System.out.printf("3개 일치 (5,000원) - %d개%n", matchingCounts[MATCH_3_PRIZE]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", matchingCounts[MATCH_4_PRIZE]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", matchingCounts[MATCH_5_PRIZE]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", matchingCounts[MATCH_5_PRIZE_BONUS]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", matchingCounts[MATCH_6_PRIZE]);
        System.out.println("");
    }

    public static void printProfit(double totalProfitRate) {
        System.out.printf("총 수익률은 %.1f %%입니다.", totalProfitRate);
    }
}
