package View;

import lotto.Prize;

import java.util.List;

public class Output {
    public static void printResult(List<Prize> prizeList) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int[] matchingCounts = new int[8];

        for (Prize prize : prizeList) {
            int matchCount = prize.getMatchCount();
            int winnersCount = prize.getWinnersCount();

            if (matchCount == 5 && prize.isBonusNumMatch()) {
                matchingCounts[7] += winnersCount;
            } else {
                matchingCounts[matchCount] += winnersCount;
            }
        }

        System.out.printf("3개 일치 (5,000원) - %d개%n", matchingCounts[3]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", matchingCounts[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", matchingCounts[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", matchingCounts[7]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", matchingCounts[6]);
        System.out.println("");
    }

    public static void printProfit(double totalProfitRate) {
        System.out.println("총 수익률은 " + totalProfitRate + "%입니다.");
    }
}
