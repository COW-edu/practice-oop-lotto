package lotto.manageLotto;

import java.util.List;
import lotto.manageError.CheckError;

public class MakeWinLotto {

  public static List<Integer> makeWinLotto(String winningNums) {
    String[] winningNumsArr = winningNums.split(",");
    List<Integer> integerList = CheckError.inputOnlyNums(winningNumsArr);

    CheckError.onlySixNums(integerList);

    for (int i = 0; i < integerList.size(); i++) {
      CheckError.numRange(integerList.get(i));
    }

    return integerList;
  }
}
