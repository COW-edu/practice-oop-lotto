package lotto.repository;

import lotto.entity.WinLotto;

public interface WinningLottoRepository {

    WinLotto getWinLotto();

    int getBonusNumber();

    void saveBonusNumber(int bonusNumber);

    void saveWinnungLotto(WinLotto winningLotto);

    void checkDuplicateBonusAndWinNumber();
}
