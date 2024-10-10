package lotto.machine;

import lotto.constant.Rank.RankEnum;
import lotto.repository.Memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningSystem {
    private final Memory memory;

    public WinningSystem(Memory memory) {
        this.memory = memory;
    }

    // Memory에서 저장된 로또 티켓과 당첨 번호를 비교하여 Rank 계산 및 수익률 반환
    public Map<RankEnum, Integer> checkWinning() {
        List<List<Integer>> tickets = memory.getGeneratedNumbers();
        List<Integer> winningNumbers = memory.getWinningNumbers();
        int bonusNumber = memory.getBonusNumber();

        Map<RankEnum, Integer> matchCount = new HashMap<>();
        int totalPrize = 0;

        // 각 티켓을 순회하며 당첨 결과 계산
        for (List<Integer> ticket : tickets) {
            int match = (int) ticket.stream().filter(winningNumbers::contains).count();
            boolean matchBonus = ticket.contains(bonusNumber);
            RankEnum rank = findRank(match, matchBonus);

            matchCount.put(rank, matchCount.getOrDefault(rank, 0) + 1);
            totalPrize += rank.getPrize();  // 당첨 금액 합산
        }

        memory.setTotalPrize(totalPrize);  // Memory에 총 당첨 금액 저장
        return matchCount;  // 당첨 통계 반환
    }

    // Rank 계산 로직
    private RankEnum findRank(int matchCount, boolean matchBonus) {
        return java.util.Arrays.stream(RankEnum.values())
                .filter(rank -> rank.getMatchCount() == matchCount && rank.isMatchBonus() == matchBonus)
                .findFirst()
                .orElse(RankEnum.NONE);
    }

    // 수익률 계산만 하고 반환
    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = memory.getTotalPrize();
        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(profitRate * 10) / 10.0;  // 소수점 둘째 자리에서 반올림
    }
}
