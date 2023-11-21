package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public OutputView() {

    }

    public void outputLottoAmount(int purchaseAmount) {
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
    }

    public void outputSelectedLottoNum(List<Lotto> selectedLottoNumList) {
        for (Lotto lotto : selectedLottoNumList) {
            System.out.println(lotto.getLottoList());
        }
    }


    public void outputWinningStatistic(int[] checkedRankList) {
        System.out.println("\n" + "당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + checkedRankList[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + checkedRankList[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + checkedRankList[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + checkedRankList[7] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + checkedRankList[6] + "개");
    }

    public void outputMoneyPercent(double result) {
        System.out.println("총 수익률은 " + result + "%입니다.");
    }
}
