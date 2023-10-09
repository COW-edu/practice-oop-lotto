package lotto.domain;

import java.util.List;

public enum Result {
    FIRST(6, 2000000000, 0),
    SECOND(5, 30000000, 0),
    THIRD(5, 1500000, 0),
    FOURTH(4, 50000, 0),
    FIFTH(3, 5000, 0);

    private final int requiredMatchCount;
    private final int prize;
    private int totalCount;

    public int getPrize() {
        return prize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    Result(int requiredMatchCount, int prize, int totalCount) {
        this.requiredMatchCount = requiredMatchCount;
        this.prize = prize;
        this.totalCount = totalCount;
    }

    public static void calculateResult(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> winningNumbers = winningLotto.getWinningLotto().getNumbers();
            int matchCount = 0;
            boolean containBonusNumber = false;

            for(int n : winningNumbers) {
                if(lotto.getNumbers().contains(n)){
                    matchCount++;
                } else if(lotto.getNumbers().contains(winningLotto.getBonusNumber())){
                    containBonusNumber = true;
                }
            }

            if(matchCount == FIRST.requiredMatchCount) {
                FIRST.totalCount++;
            }
            else if(matchCount == SECOND.requiredMatchCount && containBonusNumber) {
                SECOND.totalCount++;
            }
            else if(matchCount == THIRD.requiredMatchCount) {
                THIRD.totalCount++;
            }
            else if(matchCount == FOURTH.requiredMatchCount) {
                FOURTH.totalCount++;
            }
            else if(matchCount == FIFTH.requiredMatchCount) {
                FIFTH.totalCount++;
            }
        }

    }
}
