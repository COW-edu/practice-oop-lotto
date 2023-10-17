package lotto.entity;

import static lotto.constant.ExceptionMessage.LOTTO_DUPLICATE_BONUSE_WINNUMBER;

import java.util.ArrayList;
import java.util.List;

public class WinLottoListClass {

    private final List<Integer> winLottoList;
    private Integer bonusNumber;

    public WinLottoListClass(List<Integer> winLotto) {
        List<Integer> cloneWinLotto = new ArrayList<>(winLotto);
        this.winLottoList = new ArrayList<>(cloneWinLotto);
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
        checkDuplicateBonusAndWinNumber();
    }

    public List<Integer> getWinLotto() {
        return winLottoList;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void checkDuplicateBonusAndWinNumber() {
        if (winLottoList.stream()
            .anyMatch(number -> number == getBonusNumber())) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_BONUSE_WINNUMBER);
        }
    }

}
