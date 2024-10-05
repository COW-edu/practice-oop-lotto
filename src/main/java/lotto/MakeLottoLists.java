package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class MakeLottoLists {
  private List<List<Integer>> saveLottos;
  private List<List<Integer>> winLottos;
  private static final int DEFAULT_LOTTO_COUNT = 6;

  public MakeLottoLists() {
    this.saveLottos = new ArrayList<>();
    this.winLottos = new ArrayList<>();
  }

  public List<List<Integer>> makeInputLottoList(int price) {
    int LOTTO_COUNT = price / 1000;

    CheckError.dividedThousand(price);  // 가격 유효성 검사

    for (int i = 0; i < LOTTO_COUNT; i++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      saveLottos.add(numbers);
    }

    PrintStrings.printLottos(saveLottos, LOTTO_COUNT);
    return saveLottos;  // 반환 타입에 제네릭 추가
  }

  public List<List<Integer>> makeWinLottoList() {
    for (int i = 0; i < DEFAULT_LOTTO_COUNT; i++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      winLottos.add(numbers);
    }

    return winLottos;  // 반환 타입에 제네릭 추가
  }
}
