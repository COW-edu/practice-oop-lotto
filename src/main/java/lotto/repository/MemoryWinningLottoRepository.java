package lotto.repository;

import static lotto.constant.ExceptionMessage.LOTTO_DUPLICATE_BONUSE_WINNUMBER;

import lotto.entity.WinLotto;

public class MemoryWinningLottoRepository implements WinningLottoRepository {

    private WinLotto winningLotto;
    private int bonusNumber;

    @Override
    public void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        checkDuplicateBonusAndWinNumber();
    }

    @Override
    public void saveWinnungLotto(WinLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void checkDuplicateBonusAndWinNumber() {
        if (winningLotto.getWinningLotto().stream()
            .anyMatch(number -> number == getBonusNumber())) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_BONUSE_WINNUMBER);
        }
    }

    @Override
    public WinLotto getWinLotto() {
        return winningLotto;
    }

    @Override
    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
