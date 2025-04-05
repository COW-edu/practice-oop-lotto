package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final static String PURCHASE_MESSAGE = "구매금액을 입력해주세요.";
    private final static String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해주세요.";
    private final static String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    //구매금액
    public static int inputPrice() {
        System.out.println(PURCHASE_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    //당첨번호
    public static String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    //보너스 번호
    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
