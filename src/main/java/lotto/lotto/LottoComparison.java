package lotto.lotto;

import java.util.List;
import lotto.io.InputHandler;

public class LottoComparison {

  int matchCount = 0;
  LottoMatchCounter lottoMatchCounter;
  WinLottoMaker winLottoMaker;
  InputHandler inputHandler;
  MyLottoMaker myLottoMaker;

  public LottoComparison(LottoMatchCounter lottoMatchCounter, MyLottoMaker myLottoMaker, WinLottoMaker winLottoMaker, InputHandler inputHandler) {
    this.lottoMatchCounter = lottoMatchCounter;
    this.myLottoMaker = myLottoMaker;
    this.winLottoMaker = winLottoMaker;
    this.inputHandler = inputHandler;
    compareNums(myLottoMaker, winLottoMaker, inputHandler);
  }

  public void compareNums(MyLottoMaker myLottoMaker, WinLottoMaker winLottoMaker, InputHandler inputHandler) {
    List<List<Integer>> myLottos = myLottoMaker.getMyLottos();
    List<Integer> winLotto = winLottoMaker.getWinLotto();
    int bonusNumber = inputHandler.getBonusNum();
    for (List<Integer> myLotto : myLottos) {
      int matchCount = countMatchingNumbers(myLotto, winLotto);
      boolean bonusMatch = myLotto.contains(bonusNumber);

      lottoMatchCounter.countMatch(matchCount, bonusMatch);
    }
  }

  private int countMatchingNumbers(List<Integer> myLotto, List<Integer> winLotto) {
    for (int num : myLotto) {
      if (winLotto.contains(num)) {
        matchCount++;
      }
    }
    return matchCount;
  }

}
