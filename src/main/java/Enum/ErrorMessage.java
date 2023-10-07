package Enum;

public enum ErrorMessage {

    BUYINGRANGE("[ERROR] 구입 금액은 1000원 단위입니다."),
    DUPLICATE("[ERROR] 선택한 6개의 숫자와 보너스 숫자가 중복입니다."),
    LOTTORANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTOLENGTH("[ERROR] 로또 번호는 6개만 입력할 수 있습니다."),
    CATCHSTRING("[ERROR] 로또 번호는 숫자만 입력 가능합니다."),;

    private String exceptionMessage;

    ErrorMessage(String exception) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
