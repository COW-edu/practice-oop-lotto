package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;
  private static final int CNT_LOTTO_NUMBER = 6;

  public static List<Integer> setRandomNumbers() { //번호만 생성하기
    List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);

    return lottoNumbers;
  }
}