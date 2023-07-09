package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.model.ErrorMessage;

public class InputView {
    public String readString() {
        String res = Console.readLine();

        if (res == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NULL_INPUT.getData());
        }

        return res;
    }

    public int readInteger() {
        int res;
        try {
            res = Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INTEGER_INPUT.getData());
        }
        return res;
    }

    public

    public int[] getWinNumber() {
        String[] temp = readString().split(",");
        if (temp.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WIN_NUMBER_LENGTH.getData());
        }
        int[] winNumbers = new int[6];
        for (int i = 0; i < temp.length; i++) {
            winNumbers[i] = Integer.parseInt(temp[i]);
        }
        return winNumbers;
    }

    public int getBonusNumber(String bonusNumberLine) {
        return readInteger();
    }
}
