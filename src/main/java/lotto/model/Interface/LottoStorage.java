package lotto.model.Interface;

import java.util.List;
import lotto.model.Lotto;

public interface LottoStorage {

  void addLotto(Lotto lotto);

  List<Lotto> getLottoList();
}
