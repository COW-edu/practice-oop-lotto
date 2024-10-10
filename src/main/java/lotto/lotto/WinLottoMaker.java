package lotto.lotto;

import java.util.List;
import lotto.error.ErrorCheckingAndParsing;
import lotto.io.InputHandler;

public class WinLottoMaker {

  String[] winNumbersAsStrings;
  List<Integer> winNumbers;
  InputHandler inputHandler;

  public WinLottoMaker(InputHandler inputHandler) {
    this.inputHandler = inputHandler;
    makeWinLotto(inputHandler.getWinNums());
  }

  public void makeWinLotto(String winNumbersAsString) {
    winNumbersAsStrings = winNumbersAsString.split(",");

    winNumbers = ErrorCheckingAndParsing.isNumsAsString(winNumbersAsStrings);
    ErrorCheckingAndParsing.isOnlySixNums(winNumbers);

    for (int i = 0; i < winNumbers.size(); i++) {
      ErrorCheckingAndParsing.confirmNumRange(winNumbers.get(i));
    }
  }

  public List<Integer> getWinLotto() {
    return winNumbers;
  }

}
