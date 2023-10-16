package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;

import java.util.List;

public class LottoFactory {

    public Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
