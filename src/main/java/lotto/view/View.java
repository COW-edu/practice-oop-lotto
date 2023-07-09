package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.model.ErrorMessage;
import lotto.controller.Controller;
import lotto.model.Wallet;

import java.util.List;

public class View {
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
        String res = Console.readLine();

        if (res == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NULL_INPUT.getData());
        }

        return res;
    }

    public void getPurchasePrice(Wallet wallet) {
        Controller controller = new Controller();
        controller.handlePurchasePrice(wallet, readString());
    }

    public List<Integer> getWinNumber() {
        Controller controller = new Controller();
        return controller.handleWinNumber(readString());
    }

    public int getBonusNumber() {
        Controller controller = new Controller();
        return controller.handleBonusNumber(readString());
    }
}
