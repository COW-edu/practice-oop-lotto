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
        return lotto.getNumbers();  // Lotto 객체의 번호를 반환
    }

    // 보너스 번호를 반환하는 메서드
    public int getBonusNumber() {
        return bonusNumber;
    }
}
