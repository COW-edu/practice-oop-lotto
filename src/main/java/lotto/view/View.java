package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.model.ErrorMessage;
import lotto.controller.Controller;
import lotto.model.Wallet;

import java.util.List;

public class View {
    Controller controller = new Controller();
    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }
    public void print(int number) {
        System.out.print(number);
    }
    public void print(Double number) {
        System.out.print(number);
    }

    public String readString() {
        String result = Console.readLine();

        if (result == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NULL_INPUT.getData());
        }

        return result;
    }

    public void getPurchasePrice(Wallet wallet) {
        controller.handlePurchasePrice(wallet, readString());
    }

    public List<Integer> getWinNumber() {
        return controller.handleWinNumber(readString());
    }

    public int getBonusNumber() {
        return controller.handleBonusNumber(readString());
    }
}
