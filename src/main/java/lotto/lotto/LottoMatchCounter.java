package lotto.lotto;

import java.util.Map;

public class LottoMatchCounter {

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

  public void countMatch(int matchCount, boolean bonusMatch) {
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

  public Map<Integer, Integer> getPrizeRanking() {
    Map<Integer, Integer> prizeRanking = Map.of(
        FIRST_PLACE, sixMatch,
      SECOND_PLACE, fiveAndBonusMatch,
      THIRD_PLACE, fiveMatch,
      FOURTH_PLACE, fourMatch,
      FIFTH_PLACE, threeMatch
    );

    return prizeRanking;
  }

}
