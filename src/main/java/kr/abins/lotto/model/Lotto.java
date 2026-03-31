package kr.abins.lotto.model;

import kr.abins.lotto.Constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Constants.ERROR_LOTTO_NUMBERS_MUST_BE_SIX);
        }
        if (this.hasDuplicate(numbers)) {
            throw new IllegalArgumentException(Constants.ERROR_LOTTO_NUMBERS_DUPLICATED);
        }
        if (this.hasOutOfRange(numbers)) {
            throw new IllegalArgumentException(Constants.ERROR_LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private boolean hasDuplicate(final List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private boolean hasOutOfRange(final List<Integer> numbers) {
        for (final int number : numbers) {
            if (number < Constants.MIN_LOTTO_NUMBER || number > Constants.MAX_LOTTO_NUMBER) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> numbers() {
        return this.numbers;
    }

    public List<Boolean> match(final List<Integer> winningNumbers) {
        final List<Boolean> match = new ArrayList<>();

        for (int number : this.numbers) {
            match.add(winningNumbers.contains(number));
        }

        return match;
    }

    public int correct(final List<Integer> winningNumber) {
        final List<Boolean> match = this.match(winningNumber);

        int correct = 0;
        for (final boolean isMatch : match) {
            if (isMatch) ++correct;
        }

        return correct;
    }

    public boolean bonusMatch(final int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}