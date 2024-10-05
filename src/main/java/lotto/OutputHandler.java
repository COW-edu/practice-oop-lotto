package lotto;

public class OutputHandler {
    private static final int PRICE_THREE = 5000;
    private static final int PRICE_FOUR = 50000;
    private static final int PRICE_FIVE = 1500000;
    private static final int PRICE_FIVE_BONUS = 30000000;
    private static final int PRICE_SIX = 2000000000;

    public void printLottos(java.util.List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printStatistics(int[] matchCounts, int totalCost) {
        System.out.println("3개 일치 (5,000원) - " + matchCounts[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts[6] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[6] + "개");

        double totalPrize = matchCounts[3] * PRICE_THREE + matchCounts[4] * PRICE_FOUR
                + matchCounts[5] * PRICE_FIVE + matchCounts[6] * PRICE_SIX;
        double profitRate = (totalPrize / totalCost) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
