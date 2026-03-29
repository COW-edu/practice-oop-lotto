package domain;

import enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final List<Lotto> purchasedLottos;
    private final Lotto winLotto;
    private final BonusNumber bonusNumber;
    private final Map<Rank, Integer> rankNumber = new HashMap<>();


    public Result(List<Lotto> purchasedLottos, Lotto winLotto, BonusNumber bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
        calculate();
    }

    private void calculate() {
        for (Rank rank : Rank.values()) {
            rankNumber.put(rank, 0);
        }
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.matchCount(winLotto);
            boolean matchBonus = lotto.contains(bonusNumber.getNumber());
            Rank rank = Rank.of(matchCount, matchBonus);
            rankNumber.put(rank, rankNumber.get(rank) + 1);
        }
    }

    public int getCount(Rank rank) {
        return rankNumber.getOrDefault(rank, 0);
    }

    public long getTotalPrize(){
        long total = 0;
        for (Rank rank : Rank.values()) {
            total += (long) rank.getPrize() * rankNumber.getOrDefault(rank, 0);
        }
        return total;
    }
/*
    // 수익률 = 당첨금/구입금액 * 100
    public double getReturnRate() {
        long totalCost = purchasedLottos.size() * 1000L;
        long totalPrize = getTotalPrize();
        if (totalCost == 0) return  0;
        return (double) totalPrize / totalCost * 100;
    }
*/
}

