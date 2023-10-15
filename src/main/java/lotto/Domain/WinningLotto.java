package lotto.Domain;

import lotto.config.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    // magic number
    private static final int LOTTO_LIST_SIZE = 6;
    private static final int LOTTO_NUMBER_RANGE_FIRST = 1;
    private static final int LOTTO_NUMBER_RANGE_LAST = 45;

    //
    private List<Integer> winningNumlist = new ArrayList<>();

    public void setWinningNumlist(List<Integer> winningNumlist) {
        this.winningNumlist = winningNumlist;
        validateWinningNumber(this.winningNumlist);
    }

    private void validateWinningNumber(List<Integer> winningNumList) {
        validateWinningNumberSize(winningNumList);
        validateWinningNumberRange(winningNumList);
        validateWinningNumberDuplicate(winningNumList);
    }

    private void validateWinningNumberSize(List<Integer> winningNumList) {
        if (winningNumList.size() != LOTTO_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_LOTTONUM_COUNT.getErrorMessage());
        }
    }

    private void validateWinningNumberRange(List<Integer> winningNumList) {
        for (int checkNum : winningNumList) {
            if (checkNum < LOTTO_NUMBER_RANGE_FIRST && checkNum > LOTTO_NUMBER_RANGE_LAST) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_WINNINGNUMBER_UNREASONABLE_RANGE.getErrorMessage());
            }
        }
    }

    private void validateWinningNumberDuplicate(List<Integer> winningNumList) {
        if (winningNumList.size() != winningNumList.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_LOTTONUM_DUPLICATE.getErrorMessage());
        }
    }
}
