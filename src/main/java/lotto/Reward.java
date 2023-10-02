package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Enum.Rank;

public class Reward {

    private List<Rank> rankList;
    private List<Lotto> lottos;
    private int count;
    private int bonusNum;
    private Lotto selectLotto;
    private Lotto lotto;
    private int result;

    // 로또 결과 및 수익률 확인 로직
    public Reward(List<Lotto> lottos, int count) {
        this.lottos = lottos;
        this.count = count;
        this.rankList = new ArrayList<>();
    }

    public void compareLotto(Lotto selectLotto, int bonusNumber) {
        this.selectLotto = selectLotto;
        this.bonusNum = bonusNumber;

        for(Lotto lotto : this.lottos) {
            int rankResult = getResult(lotto);
            addRankList(rankResult);
        }
        printRank();
    }

    private int getResult(Lotto lotto) {
        this.result=0;
        this.lotto = lotto;
        List<Integer> lottoNumber = this.lotto.getLottoNumbers();
        for(int selectNumber : this.selectLotto.getLottoNumbers()) {
            if(lottoNumber.contains(selectNumber)) {
                this.result++;
            }
        }
        return result;
    }

    private void addRankList(int rankResult) {
        Rank[] values = Rank.values();
        for(Rank rank : values) {
            if(rankResult == rank.getCountMatch()) {
                saveRank(rankResult, rank);
            }
        }
    }

    private Rank bonusCheck(int rankResult, Rank rank) {
        List<Integer> lottoNumber = this.lotto.getLottoNumbers();
        if(rankResult == 5) {
            if(lottoNumber.contains(this.bonusNum)) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }
        return rank;
    }

    // 자동화 했지만 2등과 3등을 비교하는 과정에서 막힘;;
    private void saveRank(int rankResult, Rank rank) {
        if(bonusCheck(rankResult, rank) == Rank.SECOND) {
            this.rankList.add(Rank.SECOND);
        }
        if(bonusCheck(rankResult, rank) != Rank.SECOND) {
            this.rankList.add(bonusCheck(rankResult, rank));
        }
    }

    private void printRank() {
        Rank[] values = Rank.values();
        for(int i=0; i<values.length;i++) {
            System.out.println(values[i].getAnnounce() + " " + Collections.frequency(rankList, values[i])  + "개");
        }
    }

    public void getPercentage() {
        double rewardMoney = 0;
        for(Rank rank : rankList) {
            rewardMoney += rank.getReward();
        }
        double profit = (rewardMoney/(this.count*1_000))/100;
        System.out.println("총 수익률은 " + String.format("%.2f", (profit)) + "%입니다.");
    }

}