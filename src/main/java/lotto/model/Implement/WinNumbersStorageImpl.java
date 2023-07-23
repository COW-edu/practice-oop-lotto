package lotto.model.Implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.Data.ErrorMessage;
import lotto.model.Interface.WinNumbersStorage;

public class WinNumbersStorageImpl implements WinNumbersStorage {

  List<Integer> winNumbers = new ArrayList<>();
  int bonusNumber;

  WinNumbersStorageImpl(String winNumberString, int bonusNumber) {
    parseWinNumbers(winNumberString);
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

  private void parseWinNumbers(String winNumbersString) {
    String[] winNumbersStringSplit = winNumbersString.split(",");
    if (winNumbersStringSplit.length != 6) {
      throw new IllegalArgumentException(ErrorMessage.ERROR_WIN_NUMBER_LENGTH.getData());
    }
    Stream<String> winNumbersStringStream =  Arrays.stream(winNumbersStringSplit);
    try {
      winNumbersStringStream.mapToInt(Integer::parseInt).forEach(x -> winNumbers.add(x));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INTEGER_INPUT.getData());
    }
  }
}
