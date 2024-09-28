package view;

import model.CalculateSheet;
import controller.CLotto;

import java.util.Scanner;

public class VLotto {
    private final Scanner sc = new Scanner(System.in);

    // 금액 입력받기
    public int getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    // 구매한 로또 개수 출력
    public void displayLottoCount(int lottoCount) {
        System.out.println(lottoCount+"개를 구매했습니다.");
    }
}
