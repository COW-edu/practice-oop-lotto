package lotto;

import java.util.List;

public class WinningSystem {
    private final Memory memory;

    public WinningSystem(Memory memory) {
        this.memory = memory;
    }

    public void checkWinning(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        memory.saveTickets(tickets);
        memory.saveWinningNumbers(winningNumbers, bonusNumber);

        int[] matchCount = new int[Constant.Rank.values().length];

        tickets.forEach(ticket -> {
            int match = (int) ticket.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean matchBonus = ticket.getNumbers().contains(bonusNumber);
            Constant.Rank rank = Constant.Rank.findRank(match, matchBonus);
            matchCount[rank.ordinal()]++;
        });


        printResult(matchCount);
    }

    private void printResult(int[] matchCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Constant.Rank rank : Constant.Rank.values()) {
            if (rank != Constant.Rank.NONE) {
                // Use the getter method to access matchCount
                System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원) - " + matchCount[rank.ordinal()] + "개");
            }
        }
    }
}
