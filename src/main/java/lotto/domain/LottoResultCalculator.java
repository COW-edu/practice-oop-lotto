package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class LottoResultCalculator {
    public LottoStatistics calculate(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoStatistics statistics = new LottoStatistics();
        for (Lotto lotto : purchasedLottos) {
            Rank rank = winningLotto.match(lotto);
            statistics.add(rank);
        }
        return statistics;
    }
}
