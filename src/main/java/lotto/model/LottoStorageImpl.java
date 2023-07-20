package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStorageImpl implements LottoStorage {
  // TODO: 랜덤 로또 생성 메소드 추가

  private final List<Lotto> lottoList = new ArrayList<>();

  @Override
  public void addLotto(Lotto lotto) {
    lottoList.add(lotto);
  }

  @Override
  public List<Lotto> getLottoList() {
    return lottoList;
  }
}
