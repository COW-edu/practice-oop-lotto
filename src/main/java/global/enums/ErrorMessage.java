package global.enums;

public enum ErrorMessage {


    PURCHASE_AMOUNT_NEGATIVE("구매 금액은 0보다 커야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000("구매 금액은 1000 단위로 나누어 떨어져야 합니다."),
    PURCHASE_AMOUNT_NOT_NUMBER("구매 금액은 숫자여야 합니다."),



    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
