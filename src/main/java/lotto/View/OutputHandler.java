package lotto.View;

import java.util.List;

public class OutputHandler {
    public void outputLottos(int count, List<String> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (String lottoStr : lottos) {
            System.out.println(lottoStr);
        }
    }

    public void outputWinningStatics(List<Integer> countStatistics, double profitRate) {
        System.out.println("당첨 통계 \n---");
        System.out.println("3개 일치 (5,000원) - " + countStatistics.get(0));
        System.out.println("4개 일치 (50,000원) - " + countStatistics.get(1));
        System.out.println("5개 일치 (1,500,000원) - " + countStatistics.get(2));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countStatistics.get(3));
        System.out.println("6개 일치 (2,000,000,000원) - " + countStatistics.get(4));
        printProfitRate(profitRate);
    }
    private void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%");
    }
}
