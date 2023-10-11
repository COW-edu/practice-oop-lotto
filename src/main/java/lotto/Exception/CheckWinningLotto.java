package lotto.Exception;

import static lotto.Constant.LottoRule.LOTTO_ROW_SIZE;

public class CheckWinningLotto {
    //예외처리
    public static boolean checkListRange(String[] winningNum) {
        if (winningNum.length == LOTTO_ROW_SIZE) {
            return true;
        }
        try {
            throw new IllegalAccessException("[ERROR] 로또 번호는 6개를 입력해야합니다.");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static int checkNumberRange(int number) {
        if ((number > 0) && (number < 46)) {
            return number;
        }
        try {
            throw new IllegalAccessException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
