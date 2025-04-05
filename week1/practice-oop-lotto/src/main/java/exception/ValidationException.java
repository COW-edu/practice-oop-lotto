package exception;

import global.ErrorMessage;

public class ValidationException extends IllegalArgumentException {
    private final ErrorMessage.ErrorType errorType;

    public ValidationException(ErrorMessage.ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ErrorMessage.ErrorType getErrorType() {
        return errorType;
    }
}
