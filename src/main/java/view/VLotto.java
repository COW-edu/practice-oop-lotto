package view;

import java.util.List;
import java.util.Scanner;

public class VLotto {
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
    public void displayLottoNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
