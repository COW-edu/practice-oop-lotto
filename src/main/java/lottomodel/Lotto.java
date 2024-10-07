package lottomodel;

import java.util.*;

import static exception.ErrorMessage.*;

public class Lotto implements Iterable<Integer> {
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

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }

    public boolean contains(Integer element) {
        return numbers.contains(element);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
