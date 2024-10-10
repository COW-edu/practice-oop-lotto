package view;

import constant.LottoMessage;
import constant.LottoRank;
import lotto.LottoCalculator;

import java.util.List;

public class LottoResultView {
    // 생성자 지우기, 왜 만듦? 이거 만들면 안됨
    // int[] rankCount = lottoCalculator.countRanks(results);가 계산을 하는거 같아
    // View는 단순히 출력만 하기로 했는데
    LottoCalculator lottoCalculator = new LottoCalculator();

    private void printRankResults(int[] rankCount) {
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
