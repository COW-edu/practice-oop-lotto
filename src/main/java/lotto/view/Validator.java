package lotto.view;

import lotto.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public int priceValidator(String line){
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_AMOUNT.getMessage());
        }

        int purchasePrice = Integer.parseInt(line);

        // 음수 또는 0 체크
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }

        // 1000원 단위 체크
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }

        return purchasePrice;
    }

    public List<Integer> winningNumberValidator(String[] winningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbers) {
            int num = Integer.parseInt(number);

            // 번호 범위 체크 (1-45)
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
            }

            // 중복 번호 체크
            if (numbers.contains(num)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            }
            numbers.add(num);

        }
        return numbers;
    }



    public int bounusNumberValidator(int bonusNumber){
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
        return bonusNumber;
    }
}
