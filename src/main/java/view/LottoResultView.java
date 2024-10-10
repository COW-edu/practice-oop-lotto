package view;

import constant.LottoMessage;
import constant.LottoRank;
import lotto.LottoCalculator;

import java.util.List;

public class LottoResultView {

    LottoCalculator lottoCalculator = new LottoCalculator();

    private static void printRankResults(int[] rankCount) {
        System.out.println(LottoMessage.PRINT_RANK_RESULTS_HEADER);
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                String printRankResults = String.format(LottoMessage.PRINT_RANK_RESULT_FORMAT, rank.getResultMessage(), rankCount[rank.ordinal()]);
                System.out.println(printRankResults);
            }
        }
    }

    public void printResults(List<LottoRank> results, int purchaseAmount) {
        int[] rankCount = lottoCalculator.countRanks(results);
        printRankResults(rankCount);
        double yield = LottoCalculator.calculateYield(results, purchaseAmount);
        String printResults = String.format(LottoMessage.PRINT_RESULTS, yield);
        System.out.println(printResults);
    }

}
