package global.enums;

public enum ErrorMessage {


    PURCHASE_AMOUNT_NEGATIVE("구매 금액은 0보다 커야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000("구매 금액은 1000 단위로 나누어 떨어져야 합니다."),
    PURCHASE_AMOUNT_NOT_NUMBER("구매 금액은 숫자여야 합니다."),
    WINNING_NUMBER_RANGE("당첨 번호는 1부터 45 사이여야 합니다."),
    WINNING_NUMBER_LENGTH("당첨 번호는 6개여야 합니다."),
    WINNING_NUMBER_IS_NOT_NUMBER("당첨 번호는 숫자여야 합니다."),
    BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이여야 합니다."),
    BONUS_NUMBER_IS_NOT_NUMBER("보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_IS_DUPLICATE_WINNING_NUMBER("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),




    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
