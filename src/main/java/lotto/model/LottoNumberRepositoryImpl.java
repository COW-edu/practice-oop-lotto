package lotto.model;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberRepositoryImpl implements LottoNumberRepository {

  private final List<Lotto> lottoList = new ArrayList<>();

  @Override
  public void saveLotto(Lotto lotto) {
    lottoList.add(lotto);
  }

  @Override
  public List<Lotto> findLotteries() {
    return lottoList;
  }
}
