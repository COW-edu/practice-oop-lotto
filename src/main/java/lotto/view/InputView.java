package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.model.ErrorMessage;
import lotto.controller.Controller;

public class InputView {
    public String readString() {
        String res = Console.readLine();

        if (res == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NULL_INPUT.getData());
        }

        return res;
    }

    public int[] getWinNumber() {
        Controller controller = new Controller();
        return controller.handleWinNumber(readString());
    }

    public int getBonusNumber(String bonusNumberLine) {
        Controller controller = new Controller();
        return controller.handleBonusNumber(readString());
    }
}
