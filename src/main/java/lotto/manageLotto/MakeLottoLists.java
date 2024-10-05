package lotto.manageLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.manageError.CheckError;
import lotto.InOutputSystem.PrintStrings;

public class MakeLottoLists {
  private List<List<Integer>> saveLottos;

  public MakeLottoLists() {
    this.saveLottos = new ArrayList<>();
  }

  public List<List<Integer>> makeInputLottoList(int price) {
    int LOTTO_COUNT = price / 1000;

    CheckError.dividedThousand(price);

    for (int i = 0; i < LOTTO_COUNT; i++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      saveLottos.add(numbers);
    }

    PrintStrings.printLottos(saveLottos, LOTTO_COUNT);
    return saveLottos;
  }
}
