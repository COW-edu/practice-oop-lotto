package domain.calculator;

import model.BonusNumber;
import model.Lotto;
import model.constants.WinningRank;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {
    public static Map<WinningRank, Integer> calculate(List<Lotto> lottos, Lotto winningLotto, BonusNumber bonus) {
        Map<WinningRank, Integer> result = new LinkedHashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            result.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getLottoNumbers().stream()
                    .filter(winningLotto.getLottoNumbers()::contains)
                    .count();
            boolean bonusMatch = lotto.getLottoNumbers().contains(bonus.getNumber());

            WinningRank rank = WinningRank.of(matchCount, bonusMatch);
            if (rank != null) {
                result.put(rank, result.get(rank) + 1);
            }
        }

        return result;
    }
}
