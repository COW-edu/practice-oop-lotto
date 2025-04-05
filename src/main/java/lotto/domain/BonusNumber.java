package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.domain.validator.InputValidator;

public class BonusNumber {
    private final int bonusNumber;
    private final WinningNumbers winningNumbers;

    public BonusNumber(String inputBonusNumber, WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = parseAndValidateBonusNumber(inputBonusNumber);
    }

    private int parseAndValidateBonusNumber(String inputBonusNumber) {
        InputValidator.validateNotEmpty(inputBonusNumber);
        int parsedBonusNumber = parseBonusNumber(inputBonusNumber);
        InputValidator.validateInputPositiveNumber(parsedBonusNumber);
        InputValidator.validateLottoNumberRange(parsedBonusNumber);
        validateDuplicateBonusNumber(parsedBonusNumber);
        return parsedBonusNumber;
    }

    private int parseBonusNumber(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER.getMessage());
        }
    }

    private void validateDuplicateBonusNumber(int bonusNumber) {
        if (winningNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE_BONUS_WINNING.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}