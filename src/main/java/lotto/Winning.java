package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Winning {
    private List<Integer> numbers;
    public Winning(List<Integer> numbers) {
        this.numbers = numbers;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}