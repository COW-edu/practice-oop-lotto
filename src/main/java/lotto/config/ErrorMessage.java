package lotto.config;

public enum ErrorMessage {
    // [INPUT] PURCHASEMONEY
    ERROR_INPUT_EMPTY("[ERROR] 입력한 값이 없습니다"),
    ERROR_PURCHASE_MONEY_MINIMUMBER_MONEY("[ERROR] 입력한 값이 1000보다 작습니다."),
    ERROR_PURCHASE_MONEY_NO_DIVISION("[ERROR] 입력한 값이 1000으로 나누어지지 않습니다."),

    // [INPUT] WINNINGNUMBER


    ERROR_WINNING_NUMBER_UNREASONABLE_RANGE("[ERROR] 입력한 수가 1 ~ 45의 수가 아닙니다."),

    // [INPUT] BONUSNUM
    ERROR_BONUS_NUMBER_DUPLICATE("[ERROR] 당첨 번호와 중복되는 수 입니다."),

    // LOTTO
    ERROR_LOTTO_LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호 중 중복된 수가 있습니다."),
    ERROR_LOTTO_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");

    private String errorMessage;


    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
