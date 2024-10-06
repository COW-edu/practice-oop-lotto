package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.error.ErrorCheckingAndParsing;
import lotto.io.OutputHandler;

public class MyLottoMaker {

  public List<List<Integer>> makeMyLottos(int price) {
    final int MINIMUM_NUMBER = 1;
    final int MAXIMUM_NUMBER = 45;
    final int LOTTO_NUM_COUNT = 6;
    final int LOTTO_COUNT = ErrorCheckingAndParsing.isDividedThousand(price);

    List<List<Integer>> lottoStorage = new ArrayList<>();

    for (int i = 0; i < LOTTO_COUNT; i++) {
      List<Integer> myLotto = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, LOTTO_NUM_COUNT);
      lottoStorage.add(myLotto);
    }

    OutputHandler.printLottos(lottoStorage, LOTTO_COUNT);

    return lottoStorage;
  }

}
