package lotto.model;

public enum ErrorMessage {
    ERROR_NULL_INPUT("[ERROR] null 값이 입력되었습니다."),
    ERROR_NOT_INTEGER_INPUT("[ERROR] 정수가 아닌 값이 입력되었습니다."),
    ERROR_WIN_NUMBER_LENGTH("[ERROR] 로또 번호는 6개여야 합니다."),
    ERROR_PURCHASE_PRICE_UNIT("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    ERROR_REPEATED_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String data;
    ErrorMessage(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
