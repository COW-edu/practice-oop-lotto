package lotto.domain;

import java.util.List;

import static lotto.domain.Result.*;

public class ResultCalculator {

    private int matchCount;
    private boolean containBonusNumber;

    public void calculateResult(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> winningNumbers = winningLotto.getWinningLotto().getNumbers();
            matchCount = 0;
            containBonusNumber = false;

            checkContainBonusNumber(winningLotto, lotto, winningNumbers);
            checkPrize();
        }

    }

    private void checkPrize() {
        if(FIRST.getRequiredMatchCount() == matchCount) {
            FIRST.plusTotalCount();
        }
        if((SECOND.getRequiredMatchCount() == matchCount) && (containBonusNumber)) {
            SECOND.plusTotalCount();
        }
        if(THIRD.getRequiredMatchCount() == matchCount) {
            THIRD.plusTotalCount();
        }
        if(FOURTH.getRequiredMatchCount() == matchCount) {
            FOURTH.plusTotalCount();
        }
        if(FIFTH.getRequiredMatchCount() == matchCount) {
            FIFTH.plusTotalCount();
        }
    }

    private void checkContainBonusNumber(WinningLotto winningLotto, Lotto lotto, List<Integer> winningNumbers) {
        for(int n : winningNumbers) {
            if(lotto.getNumbers().contains(n)){
                matchCount++;
            } else if(lotto.getNumbers().contains(winningLotto.getBonusNumber())){
                containBonusNumber = true;
            }
        }
    }
}
