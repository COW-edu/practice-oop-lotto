package lotto.domain.validator;

import lotto.constant.ErrorMessage;

import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;

public class InputValidator {
    public static void validateInputPositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_POSITIVE_INTEGER.getMessage());
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
}