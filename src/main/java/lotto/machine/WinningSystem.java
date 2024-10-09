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

    public Map<RankEnum, Integer> checkWinning(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        memory.saveTickets(tickets);
        memory.saveWinningNumbers(winningNumbers, bonusNumber);

        Map<RankEnum, Integer> matchCount = new HashMap<>();

        tickets.forEach(ticket -> {
            int match = (int) ticket.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean matchBonus = ticket.getNumbers().contains(bonusNumber);
            RankEnum rank = findRank(match, matchBonus);

            matchCount.put(rank, matchCount.getOrDefault(rank, 0) + 1);
        });

        return matchCount; // 결과를 LottoKiosk에 반환
    }

    // Rank 계산 로직
    private RankEnum findRank(int matchCount, boolean matchBonus) {
        return java.util.Arrays.stream(RankEnum.values())
                .filter(rank -> rank.getMatchCount() == matchCount && rank.isMatchBonus() == matchBonus)
                .findFirst()
                .orElse(RankEnum.NONE);
    }
}
