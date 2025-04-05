package validator;

import exception.ValidationException;
import global.Constants;
import global.ErrorMessage;

public class PurchaseAmountValidator extends AbstractValidator<String> {

    @Override
    public void validate(String input) {
        validateNotEmpty(input, ErrorMessage.ErrorType.EMPTY_PURCHASE_AMOUNT);
        validateIsNumber(input, ErrorMessage.ErrorType.NOT_A_NUMBER);

        int amount = Integer.parseInt(input);

        if (amount <= 0 || amount % Constants.SINGLE_LOTTO_PRICE != 0) {
            throw new ValidationException(ErrorMessage.ErrorType.INVALID_AMOUNT);
        }

        if (amount > 1_000_000) {
            throw new ValidationException(ErrorMessage.ErrorType.PURCHASE_AMOUNT_TOO_LARGE);
        }
    }
}
