package lotto.message;

public enum InputMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_COUNTS("\n%d개를 구매했습니다."),
    INPUT_WIN_LOTTO_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
