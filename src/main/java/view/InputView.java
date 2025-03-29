package view;

import camp.nextstep.edu.missionutils.Console;
import global.enums.ErrorMessage;

public class InputView {
    public int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public String getWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }
}
