package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.model.Rank;

public class OutputView {
    public static void printPurchased(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatisticsHeader() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printRanks(List<Rank> ranks) {
        long fifth = ranks.stream().filter(r -> r == Rank.FIFTH).count();
        long fourth = ranks.stream().filter(r -> r == Rank.FOURTH).count();
        long third = ranks.stream().filter(r -> r == Rank.THIRD).count();
        long second = ranks.stream().filter(r -> r == Rank.SECOND).count();
        long first = ranks.stream().filter(r -> r == Rank.FIRST).count();
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
    }

    public static void printYield(double yieldPercent) {
        System.out.println("총 수익률은 " + yieldPercent + "%입니다.");
    }
}


