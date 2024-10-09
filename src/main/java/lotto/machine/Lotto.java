package lotto.machine;

import lotto.constant.Error;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    // 개수 유효성 검사
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(Error.ERROR_NUMBER_COUNT.getMessage());
        }
    }

    // 숫자 범위 유효성 검사
    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(Error.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    // 중복 유효성 검사
    private void validateDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(Error.ERROR_DUPLICATE_NUMBER.getMessage());
        }
    }

    // 로또 번호 반환
    public List<Integer> getNumbers() {
        return numbers;
    }
}
