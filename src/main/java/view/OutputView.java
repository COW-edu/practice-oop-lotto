package view;

import model.Lotto;
import model.constants.WinningRank;

import java.util.List;
import java.util.Map;

public class OutputView implements OutputViewImpl {

    @Override
    public void printPurchaseCount(int purchaseAmount) {
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
    }

    @Override
    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLottoNumbers());
        }
    }

    @Override
    public void printWinningResult(Map<WinningRank, Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("-------------------");
        for (Map.Entry<WinningRank, Integer> entry : result.entrySet()) {
            WinningRank rank = entry.getKey();
            int count = entry.getValue();
            System.out.println(rank.getDescription() + " - " + count + "개");
        }
    }

    @Override
    public void printProfitRate(float profitRate) {
        System.out.printf("총 수익률은 %.1f%% 입니다.", profitRate);
    }
}
