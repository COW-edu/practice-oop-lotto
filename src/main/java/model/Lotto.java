package model;

import global.enums.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_LENGTH.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_DUPLICATE.getMessage());
            }
        }
    }


    // TODO: 추가 기능 구현
    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
