package Domain;

import java.util.List;

public class WinningLotto {
    private List<Integer> winningNum;
    private int winningBonusNum;

    public WinningLotto(List<Integer> winningNum, int winningBonusNum) {
        validate(winningNum, winningBonusNum);
        this.winningNum = winningNum;
        this.winningBonusNum = winningBonusNum;
    }

    private void validate(List<Integer> winningNum, int winningBonusNum) {
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (winningNum.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
        if (winningNum.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNum.contains(winningBonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (winningBonusNum < 1 || winningBonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getWinningNum() {
        return winningNum;
    }

    public int getWinningBonusNum(){
        return winningBonusNum;
    }
}
