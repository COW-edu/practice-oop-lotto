package lotto.repository;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import java.util.List;

public interface LottoRepository {
    void saveLotto(Lotto lotto);

    List<Lotto> findAllLotto();

    void saveWinningNumbers(WinningNumbers winningNumbers);

    WinningNumbers findWinningNumbers();
}
