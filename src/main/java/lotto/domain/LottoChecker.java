package lotto.domain;

import lotto.constant.LottoPrize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private final List<Lotto> myLottos;
    private final WinningNumbers winningNumbers;
    private final int bonusNumber;

    public LottoChecker(List<Lotto> lottoNumbers, WinningNumbers winningNumbers, int bonusNumber) {
        this.myLottos = lottoNumbers;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoPrize, Integer> checkWinningResults() {
        Map<LottoPrize, Integer> winningResults = new HashMap<>();

        for(Lotto lotto : myLottos) {
            int matchCount = 0;
            boolean hasBonusNumber = false;

            for (Integer number : lotto.getNumbers()) {
                if (winningNumbers.hasNumber(number)) {
                    matchCount ++;
                }
            }

            if (lotto.getNumbers().contains(bonusNumber)) {
                hasBonusNumber = true;
            }

            LottoPrize prize = LottoPrize.getRank(matchCount, hasBonusNumber);

            if (prize != null) {
                winningResults.put(prize, winningResults.getOrDefault(prize, 0) + 1);
            }
        }
        return winningResults;
    }
}