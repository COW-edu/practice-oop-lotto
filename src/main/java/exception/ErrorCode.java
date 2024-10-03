package exception;

public enum ErrorCode {
    OUT_OF_RANGE("[ERROR] 1부터 45사이의 숫자를 입력해 주세요."),
    DUPLICATE_NUMBER("ERROR] 중복된 숫자가 입력되었습니다."),
    OUT_OF_UNIT("[ERROR] 1000원 단위로 입력해 주세요."),
    INVALID_NUMBER_COUNT("[ERROR] 6개의 숫자만 입력해주세요.");

    private final String errorCode;

    ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
