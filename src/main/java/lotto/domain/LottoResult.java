package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> stats;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        this.stats = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            stats.put(rank, 0);
        }
        calculate(lottos, winningLotto);
    }

    private void calculate(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            LottoRank rank = matchToRank(lotto, winningLotto);
            stats.put(rank, stats.get(rank) + 1);
        }
    }

    private LottoRank matchToRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = countMatch(lotto, winningLotto.getNumbers());
        boolean hasBonus = lotto.hasNumber(winningLotto.getBonus());

        return LottoRank.getRank(matchCount, hasBonus);
    }

    private int countMatch(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : winningNumbers) {
            count += updateCount(lotto, number);
        }
        return count;
    }

    private int updateCount(Lotto lotto, int number) {
        if (lotto.hasNumber(number)) {
            return 1;
        }
        return 0;
    }

    public Map<LottoRank, Integer> getStats() {
        return stats;
    }
}