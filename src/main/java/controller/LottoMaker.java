package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoMaker {
    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers = sortNumbers(numbers);
        return new Lotto(numbers);
    }
}
