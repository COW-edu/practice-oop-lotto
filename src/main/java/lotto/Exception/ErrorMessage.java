// ErrorMessage.java
package lotto.Exception;

public enum ErrorMessage {
    INVALID_MONEY("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1~45 사이여야 합니다."),
    INVALID_NUMBER("[ERROR] 중복된 숫자를 입력하셨습니다."),
    NOT_A_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_LOTTOSIZE("[ERROR] 로또번호는 6개여야합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
