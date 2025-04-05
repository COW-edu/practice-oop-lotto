package validator;

import exception.ValidationException;
import global.Constants;
import global.ErrorMessage;
import model.WinningNumbers;

import java.util.List;

public class BonusNumberValidator extends AbstractValidator<String> {

    private List<Integer> winningNumbers;

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers.getData();
    }

    @Override
    public void validate(String input) {
        validateNotEmpty(input, ErrorMessage.ErrorType.EMPTY_BONUS_NUMBER);
        validateIsNumber(input, ErrorMessage.ErrorType.INVALID_BONUS_NUMBER);

        int bonusNumber = Integer.parseInt(input);

        if (bonusNumber < Constants.LOTTO_MIN_NUMBER || bonusNumber > Constants.LOTTO_MAX_NUMBER) {
            throw new ValidationException(ErrorMessage.ErrorType.BONUS_NUMBER_OUT_OF_RANGE);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new ValidationException(ErrorMessage.ErrorType.BONUS_NUMBER_DUPLICATE);
        }
    }
}