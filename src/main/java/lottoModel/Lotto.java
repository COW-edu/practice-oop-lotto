package lottoModel;

import exception.ErrorCode;

import java.util.*;

import static exception.ErrorCode.*;

public class Lotto implements Iterable<Integer> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getErrorCode());
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
