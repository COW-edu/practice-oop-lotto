package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Winning {
    private List<Integer> numbers;
    public Winning() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}