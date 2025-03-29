package lotto.domain.validator;

import java.util.List;

public class BonusNumberValidator {
    public static int validateBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        if (inputBonusNumber == null || inputBonusNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해 주세요.");
        }

        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }

        if (bonusNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 양의 정수여야 합니다.");
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 다른 숫자만 가능합니다.");
        }
        return bonusNumber;
    }
}