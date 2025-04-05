package validator;

import exception.ValidationException;
import global.Constants;
import global.ErrorMessage;

import java.util.HashSet;
import java.util.Set;

public class WinningNumbersValidator extends AbstractValidator<String> {

    @Override
    public void validate(String input) {
        validateNotEmpty(input, ErrorMessage.ErrorType.EMPTY_WINNING_NUMBERS);

        String[] tokens = input.split("[,\\s]+");
        if (tokens.length != Constants.LOTTO_NUMBER_COUNT) {
            throw new ValidationException(ErrorMessage.ErrorType.INVALID_WINNING_NUMBERS_COUNT);
        }

        Set<Integer> numbers = new HashSet<>();
        for (String token : tokens) {
            validateIsNumber(token, ErrorMessage.ErrorType.NOT_A_VALID_NUMBER);
            int number = Integer.parseInt(token);
            if (number < Constants.LOTTO_MIN_NUMBER || number > Constants.LOTTO_MAX_NUMBER) {
                throw new ValidationException(ErrorMessage.ErrorType.NUMBER_OUT_OF_RANGE);
            }
            if (!numbers.add(number)) {
                throw new ValidationException(ErrorMessage.ErrorType.DUPLICATE_NUMBER);
            }
        }
    }
}