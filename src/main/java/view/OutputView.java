package view;

import lotto.Lotto;

import java.util.Collections;
import java.util.List;
import Enum.Rank;

public class OutputView {

    public void announcePayment(int payment) {
        System.out.println(payment + "개를 구매했습니다.");
    }

    public void outputReward(List<Rank> rewardList) {
        System.out.println("\n당첨 통계\n---");
        Rank[] values = Rank.values();
        for(int i=0; i<values.length-1;i++) {
            System.out.println(values[i].getAnnounceMessage() + " " + Collections.frequency(rewardList, values[i])  + "개");
        }
    }

    public void announceRandomLottos(List<Lotto> lottos) {
        for(Lotto lotto: lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void announceReward(double profit) {
        System.out.println("총 수익률은 " + String.format("%.2f", (profit)) + "%입니다.");
    }
}
