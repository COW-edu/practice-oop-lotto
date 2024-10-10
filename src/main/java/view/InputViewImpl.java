package view;

import java.util.Scanner;

public class InputViewImpl implements InputView {
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
}
