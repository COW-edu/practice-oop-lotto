package lotto.View;

import lotto.Model.Lotto;

import java.util.List;

public class OutputHandler {
    public void outputLottos(int count, List<Lotto> lottoes){
        System.out.println(count + "개를 구매했습니다.");
        for(int i=0; i<count; i++){
            System.out.println(lottoes.get(i).getNumbers());
        }
    }

    public void outputWinningStatics(List<Integer> countStatics, int confirmedMoney, int purchasingMoney){
        System.out.println("당첨 통계 \n---");
        System.out.println("3개 일치 (5,000원) - " + countStatics.get(0));
        System.out.println("4개 일치 (50,000원) - " + countStatics.get(1));
        System.out.println("5개 일치 (1,500,000원) - " + countStatics.get(2));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countStatics.get(3));
        System.out.println("6개 일치 (2,000,000,000원) - " + countStatics.get(4));
        double rate = (double) confirmedMoney / purchasingMoney;
        double rounded = Math.round(rate * 1000) / 10.0;

        System.out.println("총 수익률은 " + rounded + "%입니다.");
    }
}
