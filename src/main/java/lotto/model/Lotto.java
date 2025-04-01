package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Integer> getNumbers() {
        return numbers.stream()
                .collect(Collectors.toUnmodifiableList());
    }
    
}