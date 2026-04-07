package domain;

import static global.Constants.*;
import enums.ErrorMessage;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE.getMessage());
        }
    }


    public int getNumber() {
        return number;
    }
}