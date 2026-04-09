package kr.abins.lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import kr.abins.lotto.constant.Constants;
import kr.abins.lotto.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandom() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
            Constants.MIN_LOTTO_NUMBER,
            Constants.MAX_LOTTO_NUMBER,
            Constants.LOTTO_NUMBER_COUNT
        );

        return new Lotto(numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            ErrorMessage.LOTTO_NUMBERS_MUST_BE_SIX.throwSelf();
        }

        if (this.hasDuplicate(numbers)) {
            ErrorMessage.LOTTO_NUMBERS_DUPLICATED.throwSelf();
        }

        if (this.hasOutOfRange(numbers)) {
            ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.throwSelf();
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
}