package lotto.model;

import java.util.List;

interface LottoStorage {
    void addLotto(Lotto lotto);
    List<Lotto> getLottoList();
}
