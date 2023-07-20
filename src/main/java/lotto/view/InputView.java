package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.model.ErrorMessage;

public class InputView {

  public String readString() {
    String result = Console.readLine();

    if (result == null) {
      throw new IllegalArgumentException(ErrorMessage.ERROR_NULL_INPUT.getData());
    }

    return result;
  }

  public int readInteger() {
    return convertStringToInteger(readString());
  }

  public int convertStringToInteger(String input) {
    int output;
    try {
      output = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INTEGER_INPUT.getData());
    }
    return output;
  }
}
