package lotto.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoException;

public class WinLotto extends LottoException {

    public List<Integer> winningLotto;

    public WinLotto() {
        this.winningLotto = new ArrayList<>();
    }

    public List<Integer> drawNumber(String[] winningNum) {
        checkListRange(winningNum);
        this.winningLotto = Arrays.stream(winningNum)
            .map(String::trim)
            .map(Integer::valueOf)
            .map(WinLotto::checkNumberRange)
            .collect(Collectors.toList());
        duplicateNumberCheck(winningLotto);
        return winningLotto;
    }

}

