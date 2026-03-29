package exception;

public class ErrorMessage {

    public enum ErrorMessageType {
        NOT_NUMBER("입력값이 숫자가 아닌 경우"),
        NOT_THOUSAND("입력값이 1,000원 단위가 아닌 경우"),
        NOT_PLUS("입력값이 음수인 경우"),
        NOT_RANGE("입력값이 1 ~ 45 범위가 아닌 경우"),
        LOTTO_NUMBER_DUPLICATED("입력값이 중복인 경우"),
        NOT_SIZE("입력값의 개수가 올바르지 않은 경우");

        private final String message;
        private static final String ERROR = "[ERROR] ";

        ErrorMessageType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return ERROR + message;
        }
    }
}

