package View;

import java.util.Scanner;

public class InputView {
    public final Scanner sc = new Scanner(System.in);

    public int inputMoney(){
        System.out.println("구입 금액을 입력해 주세요.");
        int money = Integer.parseInt(sc.nextLine());
        return money;

    }

    public String[] inputNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return sc.nextLine().split(",");
    }

    public int inputBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

}
