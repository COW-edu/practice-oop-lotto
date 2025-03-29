package lotto.domain;

import lotto.domain.validator.BonusNumberValidator;
import java.util.List;

public class BonusNumberManager {
    private int bonusNumber;

    public void checkBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        this.bonusNumber = BonusNumberValidator.validateBonusNumber(inputBonusNumber, winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
