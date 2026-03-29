package view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public String purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String bonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
