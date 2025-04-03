package model;

import global.enums.ErrorMessage;
import global.enums.MagicNumber;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, Lotto winningLotto) {
        validateRange(number);
        validateNotDuplicateWithWinningNumbers(number, winningLotto.getLottoNumbers());
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MagicNumber.LOTTO_NUMBER_MIN.getValue() ||
                number > MagicNumber.LOTTO_NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateNotDuplicateWithWinningNumbers(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IS_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
