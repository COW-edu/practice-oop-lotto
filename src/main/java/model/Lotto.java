package model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS.getMessage());
        }

        for (Integer number : numbers) {
            if (number < LottoConfig.MIN_NUMBER.getValue() || number > LottoConfig.MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
