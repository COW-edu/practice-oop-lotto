package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStorageImpl implements LottoStorage {

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
