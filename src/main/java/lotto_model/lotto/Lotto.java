package lotto_model.lotto;

import java.util.*;

import static lotto_exception.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getErrorMessage());
        }
    }

    public boolean contains(Integer element) {
        return numbers.contains(element);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
