package validator;

import exception.ValidationException;
import global.ErrorMessage;

public abstract class AbstractValidator<T> implements Validator<T> {

    protected void validateNotEmpty(String input, ErrorMessage.ErrorType errorType) {
        if (input == null || input.trim().isEmpty()) {
            throw new ValidationException(errorType);
        }
    }

    protected void validateIsNumber(String input, ErrorMessage.ErrorType errorType) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ValidationException(errorType);
        }
    }
}