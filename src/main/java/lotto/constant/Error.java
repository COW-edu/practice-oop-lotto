package lotto.constant;

public enum Error {
    ERROR_INVALID_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    ERROR_INVALID_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_DUPLICATE_NUMBER("[ERROR] 중복된 번호가 존재합니다."),
    ERROR_NUMBER_COUNT("[ERROR] 로또 번호는 정확히 6개를 입력해야 합니다.");

    private final String message;

    // 생성자
    Error(String message) {
        this.message = message;
    }

    // 메시지 반환 메서드
    public String getMessage() {
        return message;
    }
}
