package lotto.constant;

import static lotto.constant.LottoRule.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoRule.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoRule.LOTTO_ROW_SIZE;

public class ExceptionMessage {

    public static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 ";
    public static final String SET_NUMBER_OF_VIOLATION = ERROR_MESSAGE + LOTTO_ROW_SIZE + "개를 입력해야합니다.";
    public static final String SET_RANGE_OF_VIOLATION =
        ERROR_MESSAGE + LOTTO_MIN_NUMBER + "부터 " + LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다.";
    public static final String LOTTO_DUPLICATE_NUMBER_VIOLATION = ERROR_MESSAGE + " 중복될 수 없습니다.";

    public static final String LOTTO_DUPLICATE_BONUSE_WINNUMBER = "보너스 번호가 중복 되었습니다.";

}
