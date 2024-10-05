package lotto.manageLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareLottos {

  public static Map<String, Integer> compareNums(List<List<Integer>> myLottos, List<Integer> winLotto, int bonusNum) {
    int sixMatch = 0;
    int fiveAndBonusMatch = 0;
    int fiveMatch = 0;
    int fourMatch = 0;
    int threeMatch = 0;

    Map<String, Integer> prizeMap = new HashMap<>();

    for (List<Integer> myLotto : myLottos) {
      int matchCount = 0;
      boolean bonusMatch = false;

      for (int num : myLotto) {
        if (winLotto.contains(num)) {
          matchCount++;
        }
      }

      if (myLotto.contains(bonusNum)) {
        bonusMatch = true;
      }


      if (matchCount == 6) {
        sixMatch++;
      } else if (matchCount == 5 && bonusMatch) {
        fiveAndBonusMatch++;
      } else if (matchCount == 5) {
        fiveMatch++;
      } else if (matchCount == 4) {
        fourMatch++;
      } else if (matchCount == 3) {
        threeMatch++;
      }
    }

    prizeMap.put("1등", sixMatch);
    prizeMap.put("2등", fiveAndBonusMatch);
    prizeMap.put("3등", fiveMatch);
    prizeMap.put("4등", fourMatch);
    prizeMap.put("5등", threeMatch);

    return prizeMap;
  }
}