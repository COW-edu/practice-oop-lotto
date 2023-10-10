package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 로또 번호를 생성
public class LottoGenerator {
  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;
  private static final int LOTTO_SIZE = 6;

  public static List<Lotto> generateLotto(int count) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      List<Integer> selectedNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
      Collections.sort(selectedNumbers);
      lottos.add(new Lotto(selectedNumbers));
    }
    return lottos;
  }
}
