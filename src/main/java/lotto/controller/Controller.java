package lotto.controller;

import lotto.model.ErrorMessage;

public class Controller {
    public int convertStringToInteger(String input) {
        int output;
        try {
            output = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INTEGER_INPUT.getData());
        }
        return output;
    }

    public int[] handleWinNumber(String winNumberLine) {
        String[] winNumberLineSplit = winNumberLine.split(",");
        if (winNumberLineSplit.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WIN_NUMBER_LENGTH.getData());
        }
        int[] winNumbers = new int[6];
        for (int i = 0; i < winNumberLineSplit.length; i++) {
            winNumbers[i] = Integer.parseInt(winNumberLineSplit[i]);
        }
        return winNumbers;
    }

    public int handleBonusNumber(String bonusNumberLine) {
        return convertStringToInteger(bonusNumberLine);
    }
}
