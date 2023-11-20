package view;

import lotto.Lotto;
import java.util.List;

public class OutputView {

    public void customerRequest() {
        System.out.println("1. 로또 구매");
        System.out.println("2. 당첨 번호 입력");
        System.out.println("3. 보너스 번호 입력");
        System.out.println("4. 결과 확인");
        System.out.println("5. 종료");
    }

    public void inputMoney() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public void inputLottoNum() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public void inputBonusNum() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public void announcePayment(int payment) {
        System.out.println(payment + "개를 구매했습니다.");
    }

    public void outputReward(List<String> rewardList) {
        System.out.println("\n당첨 통계\n---");
        for(String announce : rewardList) {
            System.out.println(announce);
        }
    }

    public void announceRandomLottos(List<Lotto> lottos) {
        for(Lotto lotto: lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void announceReward(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
