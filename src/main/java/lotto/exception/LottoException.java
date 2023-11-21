package lotto.exception;

import static lotto.constant.ExceptionMessage.LOTTO_DUPLICATE_NUMBER_VIOLATION;
import static lotto.constant.ExceptionMessage.SET_NUMBER_OF_VIOLATION;
import static lotto.constant.ExceptionMessage.SET_RANGE_OF_VIOLATION;
import static lotto.constant.LottoRule.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoRule.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoRule.LOTTO_ROW_SIZE;

import java.util.List;

public class LottoException {

    public void checkListRange(String[] winningNum) {
        if (winningNum.length != LOTTO_ROW_SIZE) {
            throw new IllegalArgumentException(SET_NUMBER_OF_VIOLATION);
        }
    }

    public static int checkNumberRange(int number) {
        if ((number >= LOTTO_MIN_NUMBER) && (number <= LOTTO_MAX_NUMBER)) {
            return number;
        }
        throw new IllegalArgumentException(SET_RANGE_OF_VIOLATION);
    }

    public void rowSizeOfViolation(List<Integer> numbers) {
        if (numbers.size() != LOTTO_ROW_SIZE) {
            throw new IllegalArgumentException(SET_NUMBER_OF_VIOLATION);
        }
    }

    public void duplicateNumberCheck(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_NUMBER_VIOLATION);
        }
    }
}
