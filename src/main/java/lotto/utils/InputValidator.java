package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static lotto.utils.LottoConstants.LOTTO_PRICE;
import static lotto.utils.InputConstants.*;

public class InputValidator {

    public void validateMoney(String input) {
        if (!input.matches("\\d+") || Integer.parseInt(input) < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_INVALID_MONEY.getMessage());
        }
    }

    public void validateWinningCount(String[] tokens) {
        if (tokens.length != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_WINNING_COUNT.getMessage());
        }
    }

    public void validateRange(int number) {
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE.getMessage());
        }
    }

    public void validateNoDupes(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER.getMessage());
        }
    }

    public void validateBonus(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LottoConstants.LOTTO_NUMBER_MIN || bonusNumber > LottoConstants.LOTTO_NUMBER_MAX || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS.getMessage());
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
