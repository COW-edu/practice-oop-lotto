package lotto.message;

public enum LottoExceptionMessage {
    NOT_CORRECT_PURCHASE_AMOUNT("[ERROR] 잘못된 입력값입니다."),
    IS_NOT_ENOUGH_LOTTO_NUMBER("[ERROR] 6개의 로또 번호를 입력해주세요"),
    UNDER_1000("[ERROR] 1000원보다 많은 금액을 입력해주세요."),
    IS_NOT_DIVIDED_1000("[ERROR] 1000으로 나누어 떨어지는 금액을 입력해주세요."),
    LOTTO_NUMBER_IN_1_45("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    IS_DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String message;
    LottoExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
