package view;

import java.util.*;

public class OutputView {
    public void printPurchasedCount(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printStatistics(Map<Integer, Integer> result, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(5, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(3, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault(2, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(1, 0) + "개");
        System.out.printf("총 수익률은 %.2f%%입니다.%n", profitRate);
    }
}

