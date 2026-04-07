package domain;

import enums.Rank;
import global.Constants;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final List<Lotto> purchasedLottos;
    private final WinningLotto winningLotto;
    private final Map<Rank, Integer> rankNumber = new EnumMap<>(Rank.class);


    public Result(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        // 7-1. null 검증
        validateNull(purchasedLottos, winningLotto);
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;

        // 7-2. 호출
        calculate();
    }

    private void validateNull(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        if (purchasedLottos == null || winningLotto == null) {
            throw new IllegalArgumentException(enums.ErrorMessage.NULL_VALUE.getMessage());
        }
    }

    private void calculate() {
        // 등수 초기화
        for (Rank rank : Rank.values()) {
            rankNumber.put(rank, 0);
        }
        for (Lotto lotto : purchasedLottos) {
            // 7-3. match() 호출
            Rank rank = winningLotto.match(lotto);
            // 등수 개수 + 해야해서 +1
            rankNumber.put(rank, rankNumber.get(rank) + 1);
        }
    }

    public int getCount(Rank rank) {
        // 각 등수 개수 확인
        return rankNumber.getOrDefault(rank, 0);
    }

    public long getTotalPrize() {
        return rankNumber.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    // 수익률 구하기
    public double getReturnRate() {
        long totalCost = (long) purchasedLottos.size() * Constants.LOTTO_PRICE;
        long totalPrize = getTotalPrize();
        if (totalCost == 0) return  0;
        double rate = (double) totalPrize / totalCost * 100;
        return Math.round(rate * 10) / 10.0;
    }
}

