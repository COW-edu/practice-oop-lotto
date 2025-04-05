package lotto.model;

import lotto.controller.LottoInput;

import java.util.List;

public class LottoCompare {
    private final List<Integer> winningNumbers;
    private int matchCount;
    private boolean bonusMatch;

    public LottoCompare(LottoDraw lottoDraw, LottoInput lottoInput) {
        this.winningNumbers = lottoInput.getLotto();
        int bonusNumber = lottoInput.getBonusNumber();
        for (List<Integer> lottoNumbers : lottoDraw.getLottos()) {
            matchCount = countMatchingNumbers(lottoNumbers);
            bonusMatch = lottoNumbers.contains(bonusNumber);
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatchCount() {
        return bonusMatch;
    }
    private int countMatchingNumbers(List<Integer> lotto) {
        return (int) lotto.stream().filter(winningNumbers::contains).count();
    }
}