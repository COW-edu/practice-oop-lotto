package lotto.view;

public enum ErrorMessage {

    ERROR_MINIMUM_PURCHASE_AMOUNT("[ERROR] 구입 금액은 최소 1,000원이 필요합니다."),
    ERROR_INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    ERROR_MESSAGE("[ERROR] 로또 번호를 6개 입력해 주세요."),
    ERROR_INVALID_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
