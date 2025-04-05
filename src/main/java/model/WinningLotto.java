package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    //유효성 검사
    private void validateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> lottoNumbers = new HashSet<>(winningNumbers);
        if (lottoNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
