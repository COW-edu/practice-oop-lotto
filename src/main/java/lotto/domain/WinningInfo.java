package lotto.domain;

import lotto.service.InputHandler;
import java.util.List;

public class WinningInfo {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningInfo(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningInfo fromInput(InputHandler inputHandler) {
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        int bonusNumber = inputHandler.getBonusNumber(winningNumbers);
        return new WinningInfo(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

