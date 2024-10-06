package lotto.lotto;

import java.util.List;
import lotto.error.ErrorCheckingAndParsing;

public class WinLottoMaker {

  public static List<Integer> makeWinLotto(String winNumbersAsString) {
    String[] winNumbersAsStrings = winNumbersAsString.split(",");

    List<Integer> winNumbers = ErrorCheckingAndParsing.isNumsAsString(winNumbersAsStrings);
    ErrorCheckingAndParsing.isOnlySixNums(winNumbers);

    for (int i = 0; i < winNumbers.size(); i++) {
      ErrorCheckingAndParsing.confirmNumRange(winNumbers.get(i));
    }

    return winNumbers;
  }

}
