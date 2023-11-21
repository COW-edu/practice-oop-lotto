package lotto.control;

import static lotto.constant.LottoRule.INT_RANGE;

import camp.nextstep.edu.missionutils.Console;


public class Input {


    public static int inputInt() {
        return Integer.valueOf(inputInt(Console.readLine()));
    }

    private static String inputInt(String input) {
        if (input.matches(INT_RANGE)) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
    }

}
