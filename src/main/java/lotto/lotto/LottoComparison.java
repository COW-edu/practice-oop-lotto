package lotto.lotto;

import java.util.List;

public class LottoComparison {

  LottoMatchCounter lottoMatchCounter;

  public LottoComparison(LottoMatchCounter lottoMatchCounter) {
    this.lottoMatchCounter = lottoMatchCounter;
  }

  public void compareNums(List<List<Integer>> myLottos, List<Integer> winLotto, int bonusNumber) {
    for (List<Integer> myLotto : myLottos) {
      int matchCount = countMatchingNumbers(myLotto, winLotto);
      boolean bonusMatch = myLotto.contains(bonusNumber);

      lottoMatchCounter.countMatch(matchCount, bonusMatch);
    }
  }

  private int countMatchingNumbers(List<Integer> myLotto, List<Integer> winLotto) {
    int matchCount = 0;
    for (int num : myLotto) {
      if (winLotto.contains(num)) {
        matchCount++;
      }
    }
    return matchCount;
  }

}
