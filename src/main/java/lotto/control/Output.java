package lotto.control;

import lotto.constant.MatchingNumberCount;
import lotto.entity.Lotto;

public class Output {

    Control control;

    public Output(Control control) {
        this.control = control;
    }

    public void askBudget() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public void printUserLottoCount() {
        System.out.println(control.user.getLottoCount() + "개를 구매했습니다.");
    }

    public void printLottoList() {
        for (Lotto lotto : control.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult() {
        String result = "당첨 통계\n---\n" +
            "3개 일치 (5,000원) - " + control.totalResult[MatchingNumberCount.THREE.getMatchingNumber()] + "개\n" +
            "4개 일치 (50,000원) - " + control.totalResult[MatchingNumberCount.FOUR.getMatchingNumber()] + "개\n" +
            "5개 일치 (1,500,000원) - " + control.totalResult[MatchingNumberCount.FIVE.getMatchingNumber()] + "개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - " + control.totalResult[MatchingNumberCount.FIVE_BONUS.getMatchingNumber()] + "개\n" +
            "6개 일치 (2,000,000,000원) - " + control.totalResult[MatchingNumberCount.SIX.getMatchingNumber()] + "개\n";
        System.out.println(result);
    }

    public void askWinLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusLottoNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printRateOfReturn() {
        System.out.println("총 수익률은 " + control.rateOfReturn + "%입니다.");
    }
}
