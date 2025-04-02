package view;

import model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView implements Output {

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
    public void printWinningResult(Map<String, Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("-------------------");
        result.forEach((key, value) -> System.out.println(key + " - " + value + "개"));
    }

    @Override
    public void printProfitRate(float profitRate) {
        System.out.printf("총 수익률은 %.1f%% 입니다.", profitRate);
    }
}
