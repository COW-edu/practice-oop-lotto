package global;

public class ErrorMessage {
    public enum ErrorType {
        EMPTY_PURCHASE_AMOUNT("구입 금액을 입력하지 않았습니다."),
        NOT_A_NUMBER("구입 금액은 숫자로 입력해야 합니다."),
        INVALID_AMOUNT("구입 금액은 1000원 단위의 양수여야 합니다."),
        PURCHASE_AMOUNT_TOO_LARGE("구입 금액이 너무 큽니다."),

        EMPTY_WINNING_NUMBERS("당첨 번호를 입력하지 않았습니다."),
        INVALID_WINNING_NUMBERS_COUNT("당첨 번호는 6개의 숫자로 입력해야 합니다."),
        NOT_A_VALID_NUMBER("당첨 번호는 숫자로 입력해야 합니다."),
        NUMBER_OUT_OF_RANGE("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
        DUPLICATE_NUMBER("당첨 번호에 중복된 숫자가 포함되어 있습니다."),

        EMPTY_BONUS_NUMBER("보너스 번호를 입력하지 않았습니다."),
        INVALID_BONUS_NUMBER("보너스 번호는 숫자로 입력해야 합니다."),
        BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
        BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다."),

        UNKNOWN_ERROR("알 수 없는 오류가 발생했습니다. 다시 시도해 주세요.");

        private static final String PREFIX = "[ERROR] ";
        private final String message;

        ErrorType(String message) {
            this.message = PREFIX + message;
        }

        public String getMessage() {
            return message;
        }
    }
}
