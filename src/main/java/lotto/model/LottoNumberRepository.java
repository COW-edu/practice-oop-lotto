package lotto.model;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoNumberRepository {

  void saveNumber(Lotto lotto);

  List<Lotto> findList();
}