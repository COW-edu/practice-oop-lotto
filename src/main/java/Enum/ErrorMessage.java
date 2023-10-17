package Enum;

import static lotto.Lotto.*;

public enum ErrorMessage {

    BUYINGRANGE("[ERROR] 구입 금액은" + PRICE + "원 단위입니다."),
    DUPLICATE("[ERROR] 선택한 번호에 중복되는 번호가 포함되어있습니다."),
    DUPLICATEBONUS("[ERROR] 선택한" + COUNT_RANGE + "개의 숫자와 보너스 숫자가 중복입니다."),
    LOTTORANGE("[ERROR] 로또 번호는 " + MIN_RANGE + "부터" + MAX_RANGE + "사이의 숫자여야 합니다."),
    LOTTOLENGTH("[ERROR] 로또 번호는" + COUNT_RANGE + "개만 입력할 수 있습니다."),
    CATCHSTRING("[ERROR] 로또 번호는 숫자만 입력 가능합니다."),;

    private String exceptionMessage;

    ErrorMessage(String exception) {
        this.exceptionMessage = exception;
    }

    public String announceException() {
        return exceptionMessage;
    }
}
