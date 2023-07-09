package lotto.model;

import java.util.List;
import lotto.model.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WIN_NUMBER_LENGTH.getData());
        }
    }

    public void print() {
        System.out.println("[" + numbers.toString() + "]");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
