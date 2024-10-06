package lotto.lotto;

import java.util.List;
import lotto.error.ErrorCheckingAndParsing;

public class WinLottoMaker {

  public static List<Integer> makeWinLotto(String winNumbersAsString) {
    String[] winNumbersAsStrings = winNumbersAsString.split(",");

    List<Integer> winNums = ErrorCheckingAndParsing.isNumsAsString(winNumbersAsStrings);
    ErrorCheckingAndParsing.isOnlySixNums(winNums);

    for (int i = 0; i < winNums.size(); i++) {
      ErrorCheckingAndParsing.numRange(winNums.get(i));
    }

    return winNums;
  }

}
