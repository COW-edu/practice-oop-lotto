package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.error.ErrorCheckingAndParsing;
import lotto.io.InputHandler;

public class MyLottoMaker {

  int LOTTO_COUNT = 0;
  final int MINIMUM_NUMBER = 1;
  final int MAXIMUM_NUMBER = 45;
  final int LOTTO_NUM_COUNT = 6;
  List<List<Integer>> lottoStorage = new ArrayList<>();
  InputHandler inputHandler;

  public MyLottoMaker(InputHandler inputHandler) {
    this.inputHandler = inputHandler;
    makeMyLottos(inputHandler.getPrice());
  }

  public void makeMyLottos(int price) {

    LOTTO_COUNT = ErrorCheckingAndParsing.isDividedThousand(price);

    for (int i = 0; i < LOTTO_COUNT; i++) {
      List<Integer> myLotto = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, LOTTO_NUM_COUNT);
      lottoStorage.add(myLotto);
    }
  }

  public List<List<Integer>> getMyLottos() {
    return lottoStorage;
  }

  public int getLottoCount(){
    return LOTTO_COUNT;
  }

}
