package lotto.machine;

import lotto.constant.Error;

public class BonusNumberValidator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Error.ERROR_INVALID_NUMBER.getMessage());
        }
    }
}
