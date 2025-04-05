package lotto.model;

import java.util.HashSet;
import java.util.List;
import static lotto.model.Constants.*;

public class Lotto {
    public static void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != SAVED_LOTTO_NUMBERS || numbers.stream().anyMatch(num -> num < MINIMUM_LOTTO_NUMBER || num > MAXIMUM_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(INVALID_NUMBERS);
        }
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_BONUSNUMBER);
        }
    }

    public static void overlapCheck(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Constants.OVERLAP_BONUSNUMBER);
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(Constants.OVERLAP_NUMBERS);
        }
    }

    public static void checkAmount(int amount) {
        if (amount % LOTTO_PRICE != 0 || amount < 0) {
            throw new IllegalArgumentException(Constants.COMPARE_AMOUNT);
        }
    }
}