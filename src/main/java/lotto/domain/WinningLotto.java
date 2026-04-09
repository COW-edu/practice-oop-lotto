package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningLotto (List<Integer> numbers, int bonus){
        validate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 중복입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
