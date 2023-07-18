package lotto.model;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoNumberRepository {

  void saveLotto(Lotto lotto);

  List<Lotto> findLotteries();
}