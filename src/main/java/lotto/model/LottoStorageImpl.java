package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStorageImpl implements LottoStorage {
  // TODO: 랜덤 로또 생성 메소드 추가

  private final List<Lotto> lottoList = new ArrayList<>();

  public LottoStorageImpl(int lottoQuantity) {
    generateLotto(lottoQuantity);
  }

  @Override
  public void addLotto(Lotto lotto) {
    lottoList.add(lotto);
  }

  @Override
  public List<Lotto> getLottoList() {
    return lottoList;
  }

  // TODO: Stream으로 구현하기
  private void generateLotto(int lottoQuantity) {
    for (int i = 0; i < lottoQuantity; i++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      Lotto lotto = new Lotto(numbers);
      addLotto(lotto);
    }
  }
}
