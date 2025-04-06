package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.*;

public class LottoCompare {
    private final List<Integer> winningNumbers;
    private final List<MatchResult> matchResults;

    public LottoCompare(LottoDraw lottoDraw, LottoInput lottoInput) {
        this.winningNumbers = lottoInput.getLotto();
        int bonusNumber = lottoInput.getBonusNumber();
        this.matchResults = new ArrayList<>();

        for (List<Integer> lottoNumbers : lottoDraw.getLottos()) {
            int matchCount = countMatchingNumbers(lottoNumbers);
            boolean bonusMatch = lottoNumbers.contains(bonusNumber);
            matchResults.add(new MatchResult(matchCount, bonusMatch));
        }
    }

    public List<MatchResult> getMatchResults() {
        return matchResults;
    }

    private int countMatchingNumbers(List<Integer> lotto) {
        return (int) lotto.stream().filter(winningNumbers::contains).count();
    }

    public static class MatchResult {
        private final int matchCount;
        private final boolean bonusMatch;

        public MatchResult(int matchCount, boolean bonusMatch) {
            this.matchCount = matchCount;
            this.bonusMatch = bonusMatch;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public boolean isBonusMatch() {
            return bonusMatch;
        }
    }
}