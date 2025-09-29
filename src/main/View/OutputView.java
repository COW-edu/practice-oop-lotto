package View;

import Domain.LottoResult;
import Domain.Rank;
import Domain.Lotto;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void getHowMany(int money){
        System.out.println("\n" + money/1000 + "개를 구매했습니다.");
    }

    public void getLottoNum(List<Lotto> lottoNum){
        for(Lotto lotto : lottoNum){
            System.out.println(lotto);
        }
    }

    public void getResult(LottoResult result){
        Map<Rank, Integer> ranks = result.getRanks();

        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + ranks.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + ranks.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranks.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranks.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranks.getOrDefault(Rank.FIRST, 0) + "개");
    }

    public void getYield(LottoResult result, int purchaseAmount){
        System.out.println("총 수익률은 " + String.format("%.1f", result.calculateYield(purchaseAmount)) + "입니다.");
    }

}