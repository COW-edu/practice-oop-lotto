package lotto.config;

public enum ErrorMessage {
    // [INPUT] PURCHASEMONEY
    ERROR_PURCHASEMONEY_UNDER_1000("[ERROR] 입력한 값이 1000보다 작습니다."),
    ERROR_PURCHASEMONEY_NO_DIVISION("[ERROR] 입력한 값이 1000으로 나누어지지 않습니다."),

    // [INPUT] WINNINGNUMBER
    ERROR_WINNINGNUMBER_UNREASONABLE_RANGE("[ERROR] 입력한 수가 1 ~ 45의 수가 아닙니다."),

    // [INPUT] BONUSNUM
    ERROR_BONUSNUM_DUPLICATE("[ERROR] 당첨 번호와 중복되는 수 입니다."),

    // LOTTO
    ERROR_LOTTO_LOTTONUM_DUPLICATE("[ERROR] 로또 번호 중 중복된 수가 있습니다."),
    ERROR_LOTTO_LOTTONUM_COUNT("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");

    private String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
