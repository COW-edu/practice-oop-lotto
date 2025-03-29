package lotto.domain;

import lotto.domain.validator.WinningNumberValidator;
import java.util.List;

public class WinningNumbersManager {
    private List<Integer> winningNumbers;

    public void checkWinningNumbers(String inputNumbers) {
        this.winningNumbers = WinningNumberValidator.validateWinningNumbers(inputNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

}
