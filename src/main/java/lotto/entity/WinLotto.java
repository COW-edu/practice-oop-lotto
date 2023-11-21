package lotto.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoException;

public class WinLotto extends LottoException {

    private List<Integer> winningLotto;

    public WinLotto() {
        this.winningLotto = new ArrayList<>();
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }

    public WinLotto drawNumber(String winningNum) {
        String[] winnngNumber = winningNum.split(",");
        checkListRange(winnngNumber);
        this.winningLotto = Arrays.stream(winnngNumber)
            .map(String::trim)
            .map(Integer::valueOf)
            .map(WinLotto::checkNumberRange)
            .collect(Collectors.toList());
        duplicateNumberCheck(winningLotto);
        return this;
    }

}

