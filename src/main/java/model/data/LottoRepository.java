package model.data;

import model.lotto.Lotto;

import java.util.List;

public interface LottoRepository {
    List<Lotto> getLottoSaved();
    void save(Lotto lotto);
}
