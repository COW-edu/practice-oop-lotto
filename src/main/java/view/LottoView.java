package view;

import java.util.List;
import java.util.Scanner;

public class LottoView {
    private final Scanner sc = new Scanner(System.in);

    // 금액 입력받기
    public int getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    // 당첨 번호 입력받기
    public String getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        if (sc.hasNextLine()) {
            sc.nextLine(); // getMoneyInput()의 nextInt() 개행문자를 비워주기 위해 호출
        }
        return sc.nextLine();
    }

    // 보너스 번호 입력받기
    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return sc.nextInt();
    }

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
    public void displayWinningList(int threeCount, int fourCount, int fiveCount, int fiveBonusCount, int sixCount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ threeCount +"개");
        System.out.println("4개 일치 (50,000원) - "+ fourCount +"개");
        System.out.println("5개 일치 (1,500,000원) - "+ fiveCount +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ fiveBonusCount +"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ sixCount +"개");
    }

    public void displayReturn(double rateReturn) {
        System.out.println("총 수익률은 "+rateReturn+"%입니다.");
    }
}
