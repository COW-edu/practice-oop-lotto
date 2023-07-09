package lotto.domain;


import lotto.message.LottoExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNotEnoughSize(numbers);
        validateDuplicate(numbers);
        validateInOneToFortyFive(numbers);
    }
    private void validateNotEnoughSize(List<Integer> numbers) {
        int LOTTO_SIZE= 6;
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoExceptionMessage.IS_NOT_ENOUGH_LOTTO_NUMBER.getMessage());
        }
    }
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoExceptionMessage.IS_DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
    private void validateInOneToFortyFive(List<Integer> numbers) {
        int START_INCLUSIVE = 1;
        int END_INCLUSIVE = 45;
        for (int number : numbers) {
            if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
                throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBER_IN_1_45.getMessage());
            }
        }
    }
}
