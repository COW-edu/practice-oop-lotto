package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.model.ErrorMessage;
import lotto.controller.Controller;

import java.util.List;

public class View {
    public String readString() {
        String res = Console.readLine();

        if (res == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NULL_INPUT.getData());
        }

        return res;
    }

    public List<Integer> getWinNumber() {
        Controller controller = new Controller();
        return controller.handleWinNumber(readString());
    }

    public int getBonusNumber(String bonusNumberLine) {
        Controller controller = new Controller();
        return controller.handleBonusNumber(readString());
    }
}
