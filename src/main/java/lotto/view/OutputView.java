package lotto.view;

import lotto.Lotto;
import java.util.List;

public class OutputView {
    /*
- 당첨 내역 출력
- 수익률 출력
 */
    public void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printMyLottos(List<Lotto> myLottos) {
        for (Lotto lotto : myLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResults() {
        System.out.println();
        System.out.println("당첨 통계 \n---");
        System.out.println("3개 일치 (5,000원) - ");
        System.out.println("4개 일치 (50,000원) - ");
        System.out.println("5개 일치 (1,500,000원) - ");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println("6개 일치 (2,000,000,000원) - ");
    }
}
