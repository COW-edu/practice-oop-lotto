package lotto.control;

import static lotto.constant.LottoRule.INT_RANGE;

import camp.nextstep.edu.missionutils.Console;


public class Input {

    Control control;

    public Input(Control control) {
        this.control = control;
    }

    private int inputInt() {
        return Integer.valueOf(inputInt(Console.readLine()));
    }

    private String inputInt(String input) {
        if (input.matches(INT_RANGE)) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
    }

    public String[] inputLineSplit() {
        return Console.readLine().split(",");
    }

    public void inputBudget() {
        control.inputBudget(inputInt());
    }

    public void inputWinningNumber() {
        control.inputWinningNumber(inputLineSplit());
    }

    public void inputBonusLottoNumber() {
        control.inputBonusLottoNumber(inputInt());
    }
}
