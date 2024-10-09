// 3주차 코드입니다 2주차로 잘못올려서 다시올립니다 ㅜㅜ

package lotto;

import constant.LottoRank;
import constant.ResultInformation;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    WinLottoView winLottoView = new WinLottoView();
    BonusLottoView bonusLottoView = new BonusLottoView();
    private List<LottoRank> results;

    public static LottoRank calculateRank(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
        boolean matchBonus = lottoNumbers.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    public static double calculateYield(List<LottoRank> results, int purchaseAmount) {
        int totalPrize = results.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
        return (totalPrize / (double) purchaseAmount) * ResultInformation.PERCENT_CONVERSION;
    }

    public List<LottoRank> calculateResults(List<Lotto> purchasedLotto, WinLotto winLotto) {
        List<LottoRank> results = new ArrayList<>();
        List<Integer> winningNumbers = winLotto.getWinningNumbers();
        int bonusNumber = winLotto.getBonusNumber();
        for (Lotto lotto : purchasedLotto) {
            LottoRank lottoRank = LottoCalculator.calculateRank(lotto.getNumbers(), winningNumbers, bonusNumber);
            results.add(lottoRank);
        }
        return results;
    }

    public int[] countRanks(List<LottoRank> results) {
        int[] rankCount = LottoRank.getRankNumbers();
        for (LottoRank rank : results) {
            rankCount[rank.getMatchCount()]++;
        }
        return rankCount;
    }
}