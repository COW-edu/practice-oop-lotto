package lotto.constant;

public enum ErrorMessage {
    EMPTY_INPUT("값을 입력해 주세요."),
    INPUT_NOT_NUMBER("숫자만 입력 가능합니다."),
    INPUT_NOT_POSITIVE_INTEGER("양수를 입력해 주세요."),
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DIVISION_LOTTO_PRICE("1000원 단위로만 구매 가능합니다."),
    INPUT_WINNING_SIX_NUMBER("당첨 번호 6개를 입력하세요."),
    NOT_DUPLICATE_WINNING_NUMBER("당첨 번호는 중복 없이 입력해야 합니다."),
    WINNING_NUMBER_NOT_SPLIT_COMMA("당첨 번호는 쉼표로 구분해야 합니다."),
    NOT_DUPLICATE_BONUS_WINNING("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}