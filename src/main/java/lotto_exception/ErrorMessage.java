package lotto_exception;

public enum ErrorMessage {
    OUT_OF_RANGE("[ERROR] 1부터 45사이의 숫자를 입력해 주세요."),
    DUPLICATE_NUMBER("ERROR] 중복된 숫자가 입력되었습니다."),
    OUT_OF_UNIT("[ERROR] 1000원 단위로 입력해 주세요."),
    INVALID_NUMBER_COUNT("[ERROR] 6개의 숫자만 입력해주세요."),
    NOT_CORRECT_LEVEL("[ERROR] 잘못된 등수가 선정되었습니다");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
