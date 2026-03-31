package kr.abins.lotto.view;

import kr.abins.lotto.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface LottoReader extends Reader {

    static int readPurchaseAmount() throws IllegalArgumentException {
        return Reader.readInt(number -> {
            if (number <= 0) {
                throw new IllegalArgumentException(Constants.ERROR_PURCHASE_AMOUNT_NOT_POSITIVE);
            }
            if (number % 1000 == 0) {
                return;
            }

            throw new IllegalArgumentException(Constants.ERROR_PURCHASE_AMOUNT_NOT_DIVISIBLE);
        });
    }

    static List<Integer> readWinningNumbers() throws IllegalArgumentException {
        final List<Integer> numbers = Reader.readInts(number -> {
            if (Constants.MIN_LOTTO_NUMBER <= number && number <= Constants.MAX_LOTTO_NUMBER) {
                return;
            }

            throw new IllegalArgumentException(Constants.ERROR_LOTTO_NUMBER_OUT_OF_RANGE);
        });

        if (numbers.size() != Constants.LOTTO_WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_LOTTO_NUMBERS_MUST_BE_SIX);
        }

        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(Constants.ERROR_LOTTO_NUMBERS_DUPLICATED);
        }

        return numbers;
    }

    static int readBonusNumber() throws IllegalArgumentException {
        return Reader.readInt(number -> {
            if (Constants.MIN_LOTTO_NUMBER <= number && number <= Constants.MAX_LOTTO_NUMBER) {
                return;
            }

            throw new IllegalArgumentException(Constants.ERROR_LOTTO_NUMBER_OUT_OF_RANGE);
        });
    }

    static void validateBonusNumber(final int bonusNumber, final List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Constants.ERROR_BONUS_NUMBER_DUPLICATED);
        }
    }

    private static boolean hasDuplicate(final List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
