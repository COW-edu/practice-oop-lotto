package lotto.Output;

import java.util.ArrayList;
import lotto.Constant.MatchingNumberCount;
import lotto.Entity.Lotto;

public class PrintOut {
    //출력 돕는 객체
    public PrintOut() {

    }


    public void printLottoList(ArrayList<Lotto> lottoLists) {
        for (Lotto lotto : lottoLists) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(int[] totalResult) {
        String result = "당첨 통계\n---\n" +
            "3개 일치 (5,000원) - " + totalResult[MatchingNumberCount.THREE.getMatchingNumber()] + "개\n" +
            "4개 일치 (50,000원) - " + totalResult[MatchingNumberCount.FOUR.getMatchingNumber()] + "개\n" +
            "5개 일치 (1,500,000원) - " + totalResult[MatchingNumberCount.FIVE.getMatchingNumber()] + "개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalResult[MatchingNumberCount.FIVE_BONUS.getMatchingNumber()] + "개\n" +
            "6개 일치 (2,000,000,000원) - " + totalResult[MatchingNumberCount.SIX.getMatchingNumber()] + "개\n";
        System.out.println(result);
    }
}
