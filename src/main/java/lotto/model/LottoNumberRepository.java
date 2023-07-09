package lotto.model;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoNumberRepository {
    void saveLottoList(Lotto lotto);
    List<Lotto> findLottoList();
}