package lotto.domain;

import java.util.List;

public enum Result {
    FIRST(6, 2000000000, 0),
    SECOND(5, 30000000, 0),
    THIRD(5, 1500000, 0),
    FOURTH(4, 50000, 0),
    FIFTH(3, 5000, 0);

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    private final int rank;
    private final int prize;
    private int totalCount;

    Result(int rank, int prize, int totalCount) {
        this.rank = rank;
        this.prize = prize;
        this.totalCount = totalCount;
    }

    public static void calculateResult(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> winningNumbers = winningLotto.getWinningLotto().getNumbers();
            int matchCount = 0;
            boolean containBonusNumber = false;
            for(int n : winningNumbers) {
                if(winningLotto.contain(n)){
                    matchCount++;
                } else if(lotto.getNumbers().contains(winningLotto.getBonusNumber())){
                    containBonusNumber = true;
                }
            }
            if(matchCount == 6) {
                FIRST.totalCount++;
            }
            else if(matchCount == 5 && containBonusNumber) {
                SECOND.totalCount++;
            }
            else if(matchCount == 5) {
                THIRD.totalCount++;
            }
            else if(matchCount == 4) {
                FOURTH.totalCount++;
            }
            else if(matchCount == 3) {
                FIFTH.totalCount++;
            }
        }
    }
}
