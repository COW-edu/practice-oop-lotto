package lotto.domain.validator;

import lotto.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.LottoConstants.*;

public class WinningNumberValidator {
    public static void validateWinningNumbers(List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_WINNING_SIX_NUMBER.getMessage());
        }

        for (int number : parsedNumbers) {
            InputValidator.validateLottoNumberRange(number);
        }

        // 중복된 숫자가 있을 경우 예외처리
        Set<Integer> uniqueNumbers = new HashSet<>(parsedNumbers);
        if (uniqueNumbers.size() != parsedNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}