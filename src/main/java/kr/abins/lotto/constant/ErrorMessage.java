package kr.abins.lotto.constant;

public enum ErrorMessage {

    ONLY_INTEGER("숫자만 입력 가능합니다."),
    PURCHASE_AMOUNT_NOT_DIVISIBLE("구입 금액은 1,000원 단위여야 합니다."),
    PURCHASE_AMOUNT_NOT_POSITIVE("구입 금액은 0보다 커야 합니다."),
    LOTTO_NUMBERS_MUST_BE_SIX("로또 번호는 6개여야 합니다."),
    WINNING_LOTTO_NUMBERS_MUST_BE_SIX("로또 당첨 번호는 6개여야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_DUPLICATED("로또 번호에 중복된 숫자가 있습니다."),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
    
    private static final String prefix = "[ERROR] ";
    private final String message;
    
    ErrorMessage(String message) {
        this.message = message;    
    }

    public void throwSelf() {
        throw new IllegalArgumentException(this.toString());
    }
    
    public String message() {
        return this.message;
    }
    
    public String toString() {
        return prefix + this.message;
    }
}
