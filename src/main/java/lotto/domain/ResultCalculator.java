package lotto.domain;

import java.util.List;

import static lotto.domain.Result.*;

public class ResultCalculator {
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

            if(FIRST.getRequiredMatchCount() == matchCount) {
                FIRST.plusTotalCount();
            }
            else if((SECOND.getRequiredMatchCount() == matchCount) && (containBonusNumber)) {
                SECOND.plusTotalCount();
            }
            else if(THIRD.getRequiredMatchCount() == matchCount) {
                THIRD.plusTotalCount();
            }
            else if(FOURTH.getRequiredMatchCount() == matchCount) {
                FOURTH.plusTotalCount();
            }
            else if(FIFTH.getRequiredMatchCount() == matchCount) {
                FIFTH.plusTotalCount();
            }
        }

    }
}
