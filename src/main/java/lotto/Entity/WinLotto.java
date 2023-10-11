package lotto.Entity;

import java.util.ArrayList;
import java.util.List;
import lotto.Exception.CheckWinningLotto;

public class WinLotto {
    // 당첨 로또
    public final List<Integer> winningLotto;

    public WinLotto() {
        this.winningLotto = new ArrayList<>();
    }


    public List<Integer> drawNumber(String[] winningNum) {
        CheckWinningLotto.checkListRange(winningNum);
        for (String number : winningNum) {
            this.winningLotto.add(
                CheckWinningLotto.checkNumberRange(Integer.parseInt(number.trim())));
        }
        return winningLotto;
    }

    public List<Integer> drawBonus(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto.add(
            CheckWinningLotto.checkNumberRange(bonusNumber));
        return winningLotto;
    }

}

