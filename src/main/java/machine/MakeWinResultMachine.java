package machine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import model.lotto.Lotto;
import model.lotto.LottoData;
import model.lotto.PayLottos;
import model.win.WinLottoCount;

public class MakeWinResultMachine {

  public Map<String, Integer> makeWinLottoResultData(int[] equalCounts, boolean[] bonusCounts,
      int countOfLotto) {
    Map<String, Integer> winCountTemp = new HashMap<>();
    for (WinLottoCount wincount : WinLottoCount.values()) {
      double winNumber = Double.parseDouble(wincount.getCount());
      winCountTemp.put(wincount.getCount(),
          countWin(winNumber, equalCounts, bonusCounts, countOfLotto));
    }
    return winCountTemp;
  }

  private int countWin(double winNumber, int[] equalCounts, boolean[] bonusCounts,
      int countOfLotto) {
    int count = 0;
    boolean isInteger = (winNumber % 1 == 0);
    for (int i = 0; i < countOfLotto; i++) {
      if (!isInteger && equalCounts[i] == (int) winNumber && bonusCounts[i]) {
        count++;
        continue;
      }
      if (isInteger && equalCounts[i] == winNumber && bonusCounts[i]) {
        continue;
      }
      if (equalCounts[i] == winNumber) {
        count++;
      }
    }
    return count;
  }
}
