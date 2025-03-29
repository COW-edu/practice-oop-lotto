package model;

import java.util.List;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bounsNumber;

    public WinningLotto(List<Integer> winningNumbers, int bounsNumber) {
        validateWinningNumbers(winningNumbers, bounsNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bounsNumber = bounsNumber;
    }

    //유효성 검사
    private void validateWinningNumbers(List<Integer> winningNumbers, int bounsNumber) {
        if (winningNumbers.contains(bounsNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBounsNumber() {
        return bounsNumber;
    }
}
