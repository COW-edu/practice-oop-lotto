package lotto;

import java.util.List;

public class WinLotto {

    private Lotto lotto;
    private int bonusNumber;

    public WinLotto(List<Integer> lottoNumbers, int bonusNumber) {
        lotto = new Lotto(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
