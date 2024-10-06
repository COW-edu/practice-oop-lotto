// 3주차 코드입니다 2주차로 잘못올려서 다시올립니다 ㅜㅜ

package lotto;

import java.util.List;

public class LottoCalculator {

    public static LottoRank calculateRank(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
        boolean matchBonus = lottoNumbers.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    public static double calculateYield(List<LottoRank> results, int purchaseAmount) {
        int totalPrize = results.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
        int percentConversion = 100;
        return (totalPrize / (double) purchaseAmount) * percentConversion;
    }
}