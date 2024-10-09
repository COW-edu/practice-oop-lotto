package lotto_model;

import java.util.List;

public interface LottoRepository {
    List<Lotto> getLottoSaved();
    void save(Lotto lotto);
}
