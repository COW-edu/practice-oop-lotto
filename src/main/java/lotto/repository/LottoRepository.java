package lotto.repository;

import lotto.model.Lotto;
import java.util.List;

public interface LottoRepository {
    void saveLotto(Lotto lotto);
    List<Lotto> findAllLotto();
}