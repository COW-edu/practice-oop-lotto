package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Data.ErrorMessage;

public class WinNumbersStorageImpl implements WinNumbersStorage {

  List<Integer> winNumbers = new ArrayList<>();
  int bonusNumber;

  WinNumbersStorageImpl(String winNumberString, int bonusNumber) {
    this.winNumbers = parseWinNumbers(winNumberString);
    this.bonusNumber = bonusNumber;
  }

  @Override
  public List<Integer> getWinNumbers() {
    return null;
  }

  @Override
  public int getBonusNumber() {
    return 0;
  }

  private List<Integer> parseWinNumbers(String winNumbersString) {
    String[] winNumbersStringSplit = winNumbersString.split(",");
    if (winNumbersStringSplit.length != 6) {
      throw new IllegalArgumentException(ErrorMessage.ERROR_WIN_NUMBER_LENGTH.getData());
    }
    List<Integer> winNumbers = new ArrayList<>();
    for (String s : winNumbersStringSplit) {
      try {
        winNumbers.add(Integer.parseInt(s));
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INTEGER_INPUT.getData());
      }
    }
    return winNumbers;
  }
}
