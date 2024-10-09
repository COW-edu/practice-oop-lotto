package lotto;

import java.util.List;

public class LottoResultView {

    LottoCalculator lottoCalculator = new LottoCalculator();

    private static void printRankResults(int[] rankCount) {
        String printRankResultsHeader = "당첨 통계\n---";
        System.out.println(printRankResultsHeader);
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                String printRankResults = rank.getResultMessage() + " - " + rankCount[rank.ordinal()] + "개";
                System.out.println(printRankResults);
            }
        }
    }

    public void printResults(List<LottoRank> results, int purchaseAmount) {
        int[] rankCount = lottoCalculator.countRanks(results);
        printRankResults(rankCount);
        double yield = LottoCalculator.calculateYield(results, purchaseAmount);
        String printResults = "총 수익률은 " + yield + "%입니다.";
        System.out.println(printResults);
    }

}
