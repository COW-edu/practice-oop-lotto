package global;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validatePurchaseAmount(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_AMOUNT);
        }

        int amount;

        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER);
        }

        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT);
        }
        if (amount > 1000000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_TOO_LARGE);
        }
    }

    public static void validateWinningNumbers(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_WINNING_NUMBERS);
        }

        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT);
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String number : numbers) {
            int num;
            try {
                num = Integer.parseInt(number.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.NOT_A_VALID_NUMBER);
            }

            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE);
            }

            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
            }
        }
    }

    public static void validateBonusNumber(String input, int[] winningNumbers) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_BONUS_NUMBER);
        }

        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER);
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE);
        }

        if (Arrays.stream(winningNumbers).anyMatch(num -> num == bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE);
        }
    }
}
