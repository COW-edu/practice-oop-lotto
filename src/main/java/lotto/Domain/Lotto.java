package lotto.Domain;

import lotto.config.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    public List<Integer> getLottoList() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        duplicateValidate(numbers);
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_LOTTO_NUMBER_COUNT.getErrorMessage());
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_LOTTO_NUMBER_DUPLICATE.getErrorMessage());
        }
    }
}
