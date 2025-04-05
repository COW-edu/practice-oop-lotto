package model;

public enum ErrorMessage {
    INVALID_PRICE_UNIT("[ERROR] 금액은 1,000원 단위여야 합니다."),
    INVALID_LOTTO_NUMBERS("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    DUPLICATE_LOTTO_NUMBERS("[ERROR] 당첨 번호 목록에 중복된 숫자가 포함될 수 없습니다."),
    NOT_A_NUMBER("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
