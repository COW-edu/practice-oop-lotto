package lotto.view;

import java.util.Map;
import lotto.constant.MatchingNumberCount;

public class ResultView implements Viewable {

    @Override
    public void render(Map<String, Object> model) {
        printResult((int[]) model.get("resultList"));
        printRateOfReturn((double) model.get("rateOfReturn"));
    }

    private void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public void printResult(int[] totalResult) {
        String result = "당첨 통계\n---\n" +
            "3개 일치 (5,000원) - " + totalResult[MatchingNumberCount.THREE.getMatchingNumber()] + "개\n" +
            "4개 일치 (50,000원) - " + totalResult[MatchingNumberCount.FOUR.getMatchingNumber()] + "개\n" +
            "5개 일치 (1,500,000원) - " + totalResult[MatchingNumberCount.FIVE.getMatchingNumber()] + "개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalResult[MatchingNumberCount.FIVE_BONUS.getMatchingNumber()] + "개\n" +
            "6개 일치 (2,000,000,000원) - " + totalResult[MatchingNumberCount.SIX.getMatchingNumber()] + "개\n";
        System.out.print(result);

    }
}
