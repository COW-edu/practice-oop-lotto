package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryNumberValidator {
    public static final String INVALID_NUMBER_ERROR_MESSAGE = "[ERROR] 1 ~ 45 범위의 숫자를 입력하세요.";
    public static final String INVALID_PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_FORMAT_ERROR_MESSAGE = "[ERROR] 구입 금액에 문자가 포함되어 있습니다.";
    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        numbers.stream()
                .filter(number -> !uniqueNumbers.add(number))
                .findFirst()
                .ifPresent(duplicate -> {
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.");
                });
    }
    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println(INVALID_NUMBER_ERROR_MESSAGE);
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
        }
    }
    public static void validatePurchaseAmountDivisibility(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            System.out.println(INVALID_PURCHASE_AMOUNT_ERROR_MESSAGE);
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
    }
    public static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            System.out.println(INVALID_PURCHASE_AMOUNT_FORMAT_ERROR_MESSAGE);
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT_ERROR_MESSAGE);
        }
    }



}
