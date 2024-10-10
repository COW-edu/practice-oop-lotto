package view;

import java.util.List;
import java.util.Map;

public class OutputViewImpl implements OutputView {
    private static final int THREE_COUNT = 3;
    private static final int FOUR_COUNT = 4;
    private static final int FIVE_COUNT = 5;
    private static final int BONUS_COUNT = 1;
    private static final int SIX_COUNT = 6;

    // 구매한 로또 개수 출력
    public void displayLottoCount(int lottoCount) {
        System.out.println(lottoCount+"개를 구매했습니다.");
    }

    // 구매한 로또 번호 리스트 출력
    public void displayLottoNumber(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    // 당첨 통계 출력
    public void displayWinningList(Map<Integer, Integer> matchCountStatistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ matchCountStatistics.get(THREE_COUNT) +"개");
        System.out.println("4개 일치 (50,000원) - "+ matchCountStatistics.get(FOUR_COUNT) +"개");
        System.out.println("5개 일치 (1,500,000원) - "+ matchCountStatistics.get(FIVE_COUNT) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ matchCountStatistics.get(BONUS_COUNT) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ matchCountStatistics.get(SIX_COUNT) +"개");
    }

    public void displayReturn(double rateReturn) {
        System.out.println("총 수익률은 "+rateReturn+"%입니다.");
    }
}
