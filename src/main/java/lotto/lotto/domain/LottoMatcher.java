package lotto.lotto.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoMatcher {

    public static final Set<LottoReward> REWARDS = new HashSet<>();
    private static LottoResult RESULT;

    static {
        addWinningReward(6, 0, 2_000_000_000);
        addWinningReward(5, 1, 30_000_000);
        addWinningReward(5, 0, 1_500_000);
        addWinningReward(4, 0, 50_000);
        addWinningReward(3, 0, 5_000);
    }

    private static void addWinningReward(int matchedNumbers, int matchedBonusNumbers, int winningPrice) {
        var secondWinningReward = LottoReward.builder()
                                             .matchedNumbers(matchedNumbers)
                                             .matchedBonusNumbers(matchedBonusNumbers)
                                             .winningPrice(winningPrice)
                                             .build();
        REWARDS.add(secondWinningReward);
    }

    public static void setResult(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (RESULT == null) {
            RESULT = LottoResult.of(numbers, bonusNumber);
        }
    }

    public static void match(Lotto lotto) {
        var matchedNumbers = 0;
        var matchedBonusNumbers = 0;

        for (LottoNumber lottoNumber: lotto.getNumbers()) {
            if (RESULT.containWinningNumbers(lottoNumber)) {
                matchedNumbers++;
            }

            if (RESULT.containBonusNumbers(lottoNumber)) {
                matchedBonusNumbers++;
            }
        }

        var sortedRewards = REWARDS.stream().sorted((lr1, lr2) -> lr2.getWinningPrice() - lr1.getWinningPrice()).collect(Collectors.toList());
        for (LottoReward lottoReward : sortedRewards) {
            if (lottoReward.match(matchedNumbers, matchedBonusNumbers)) {
                lotto.finish(lottoReward);
                break;
            }
        }
    }
}
