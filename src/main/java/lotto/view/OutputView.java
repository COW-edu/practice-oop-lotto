package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(this::printSingleLotto);
    }

    private void printSingleLotto(Lotto lotto) {
        List<Integer> sortedNumbers = lotto.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNumbers);
    }

    public void printWinningStatistics(Map<Rank, Integer> result) {
        System.out.println("\n당첨 통계\n---");
        printRankResult(Rank.FIFTH, result);
        printRankResult(Rank.FOURTH, result);
        printRankResult(Rank.THIRD, result);
        printRankResult(Rank.SECOND, result);
        printRankResult(Rank.FIRST, result);
    }

    private void printRankResult(Rank rank, Map<Rank, Integer> result) {
        int count = result.getOrDefault(rank, 0);
        System.out.printf(rank.getMessage(), count);
    }

    public void printYield(double yield) {
        // 소수점 둘째 자리에서 반올림하여 첫째 자리까지 출력 (ex. 62.5%)
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", yield);
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}