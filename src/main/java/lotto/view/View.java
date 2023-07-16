package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.model.ErrorMessage;
import lotto.controller.Controller;
import lotto.model.Wallet;

import java.util.List;

public class View {
    Controller controller = new Controller();

    public String readString() {
        String result = Console.readLine();

        if (result == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NULL_INPUT.getData());
        }

        return result;
    }

    public void readPurchasePrice(Wallet wallet) {
        controller.handlePurchasePrice(wallet, readString());
    }

    public List<Integer> readWinNumber() {
        return controller.handleWinNumber(readString());
    }

    public int readBonusNumber() {
        return controller.handleBonusNumber(readString());
    }
}
