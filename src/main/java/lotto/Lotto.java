package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }


    // TODO: 추가 기능 구현
}
