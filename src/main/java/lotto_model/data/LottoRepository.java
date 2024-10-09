package lotto_model.data;

import lotto_model.lotto.Lotto;

import java.util.List;

public interface LottoRepository {
    List<Lotto> getLottoSaved();
    void save(Lotto lotto);
}
