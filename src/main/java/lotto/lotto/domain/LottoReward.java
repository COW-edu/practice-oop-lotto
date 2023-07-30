package lotto.lotto.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class LottoReward {
    private final LottoMatchingInfo matchingInfo;
    private final int winningPrice;

    @Builder
    public LottoReward(int matchedNumbers, int matchedBonusNumbers, int winningPrice) {
        this.matchingInfo = LottoMatchingInfo.builder()
                                             .matchedNumbers(matchedNumbers)
                                             .matchedBonusNumbers(matchedBonusNumbers)
                                             .build();
        this.winningPrice = winningPrice;
    }

    public int getMatchedNumbers() {
        return matchingInfo.getMatchedNumbers();
    }

    public int getMatchedBonusNumbers() {
        return matchingInfo.getMatchedBonusNumbers();
    }

    public boolean match(int matchedNumbers, int matchedBonusNumbers) {
        return matchedNumbers == matchingInfo.getMatchedNumbers() && matchedBonusNumbers >= matchingInfo.getMatchedBonusNumbers();
    }
}
