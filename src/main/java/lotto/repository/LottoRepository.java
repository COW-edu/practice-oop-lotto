package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.entity.Lotto;

public interface LottoRepository {


    List<Lotto> getLottoList();

    void saveLotto(ArrayList<Lotto> lottos);
}
