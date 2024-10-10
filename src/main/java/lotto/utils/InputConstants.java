package lotto.utils;

public enum InputConstants {

    GET_MONEY_PROMPT("구입 금액을 입력해 주세요."),
    GET_WINNING_PROMPT("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)"),
    GET_BONUS_PROMPT("보너스 번호를 입력해 주세요."),
    PARSING_CRITERIA(","),
    ERROR_INVALID_MONEY("[ERROR] 유효한 금액을 입력해 주세요. 금액은 1000원 이상이어야 합니다."),
    ERROR_INVALID_WINNING_COUNT("[ERROR] 당첨 번호는 6개여야 합니다."),
    ERROR_INVALID_RANGE("[ERROR] 번호는 1부터 45 사이여야 합니다."),
    ERROR_DUPLICATE_NUMBER("[ERROR] 중복된 번호가 있습니다."),
    ERROR_INVALID_BONUS("[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않는 번호여야 합니다.");

    private final String message;

    InputConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
