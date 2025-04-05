package lotto;

import java.util.*;

public class WinningLotto {
    private final LottoDraws lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new LottoDraws(numbers);
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public LottoDraws getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}