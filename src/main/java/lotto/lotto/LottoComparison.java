package lotto.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoComparison {

  public static Map<Integer, Integer> compareNums(List<List<Integer>> myLottos, List<Integer> winLotto, int bonusNumber) {

    int sixMatch = 0;
    int fiveAndBonusMatch = 0;
    int fiveMatch = 0;
    int fourMatch = 0;
    int threeMatch = 0;
    final int FIRST_PLACE = 6;
    final int SECOND_PLACE = 5;
    final int THIRD_PLACE = 4;
    final int FOURTH_PLACE = 3;
    final int FIFTH_PLACE = 2;

    Map<Integer, Integer> prizeRanking = new HashMap<>();

    for (List<Integer> myLotto : myLottos) {
      int matchCount = 0;
      boolean bonusMatch = false;

      for (int num : myLotto) {
        if (winLotto.contains(num)) {
          matchCount++;
        }
      }

      if (myLotto.contains(bonusNumber)) {
        bonusMatch = true;
      }


      switch (matchCount) {
        case 6:
          sixMatch++;
          break;
        case 5:
          if (bonusMatch) {
            fiveAndBonusMatch++;
          } else {
            fiveMatch++;
          }
          break;
        case 4:
          fourMatch++;
          break;
        case 3:
          threeMatch++;
          break;
      }
    }

    prizeRanking.put(FIRST_PLACE, sixMatch);
    prizeRanking.put(SECOND_PLACE, fiveAndBonusMatch);
    prizeRanking.put(THIRD_PLACE, fiveMatch);
    prizeRanking.put(FOURTH_PLACE, fourMatch);
    prizeRanking.put(FIFTH_PLACE, threeMatch);

    return prizeRanking;
  }

}
