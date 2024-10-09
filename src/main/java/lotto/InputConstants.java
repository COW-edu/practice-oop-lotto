package lotto;

public enum InputConstants {

    GET_MONEY_PROMPT("구입 금액을 입력해 주세요."),
    GET_WINNING_PROMPT("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)"),
    GET_BONUS_PROMPT("보너스 번호를 입력해 주세요."),
    PARSING_CRITERIA(",");

    private final String message;

    InputConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

