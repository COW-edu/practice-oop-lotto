package lotto;

public class ErrorMessage {
    public static final String EMPTY_PURCHASE_AMOUNT = "[ERROR] 구입 금액을 입력하지 않았습니다.";
    public static final String NOT_A_NUMBER = "[ERROR] 구입 금액은 숫자로 입력해야 합니다.";
    public static final String INVALID_AMOUNT = "[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.";
    public static final String PURCHASE_AMOUNT_TOO_LARGE = "[ERROR] 구입 금액이 너무 큽니다.";

    public static final String EMPTY_WINNING_NUMBERS = "[ERROR] 당첨 번호를 입력하지 않았습니다.";
    public static final String INVALID_WINNING_NUMBERS_COUNT = "[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다.";
    public static final String NOT_A_VALID_NUMBER = "[ERROR] 당첨 번호는 숫자로 입력해야 합니다.";
    public static final String NUMBER_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBER = "[ERROR] 당첨 번호에 중복된 숫자가 포함되어 있습니다.";

    public static final String EMPTY_BONUS_NUMBER = "[ERROR] 보너스 번호를 입력하지 않았습니다.";
    public static final String INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 숫자로 입력해야 합니다.";
    public static final String BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
}
