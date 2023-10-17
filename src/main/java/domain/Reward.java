package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import Enum.Rank;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import static lotto.Lotto.PRICE;

public class Reward {

    private final int count;

    private List<Rank> rankList;
    private List<Lotto> lottos;
    private int bonusNum;
    private Lotto selectLotto;
    private Lotto lotto;

    // 로또 결과 및 수익률 확인 로직
    public Reward(List<Lotto> lottos, int count, Lotto selectLotto, int bonusNum) {
        this.lottos = lottos;
        this.count = count;
        this.selectLotto = selectLotto;
        this.bonusNum = bonusNum;
        this.rankList = new ArrayList<>();
    }

    public List<Rank> compareLotto() {
        for(Lotto lotto : this.lottos) {
            this.rankList = addRankList(countResult(lotto));
        }
        return this.rankList;
    }

    private int countResult(Lotto lotto) {
        this.lotto = lotto;
        List<Integer> lottoNumber = this.lotto.getLottoNumbers();
        return (int) this.selectLotto.getLottoNumbers().stream()
                .filter(selectNumber -> lottoNumber.contains(selectNumber))
                .count();
    }

    private List<Rank> addRankList(int rankResult) {
        for(Rank rank : Rank.values()) {
            if(rankResult == rank.getCountMatch()) {
                saveRank(rankResult);
                break;
            }
        }
        return this.rankList;
    }

    private void saveRank(int rankResult) {
        if(rankResult == Rank.FIRST.getCountMatch()) {
            this.rankList.add(Rank.FIRST);
        }
        if(rankResult == Rank.SECOND.getCountMatch() && bonusCheck()) {
            this.rankList.add(Rank.SECOND);
        }
        if(rankResult == Rank.THIRD.getCountMatch() && !bonusCheck()) {
            this.rankList.add(Rank.THIRD);
        }
        if(rankResult == Rank.FOURTH.getCountMatch()) {
            this.rankList.add(Rank.FOURTH);
        }
        if(rankResult == Rank.FIFTH.getCountMatch()) {
            this.rankList.add(Rank.FIFTH);
        }
        this.rankList.add(Rank.MISS);
    }

    private boolean bonusCheck() {
        List<Integer> lottoNumber = this.lotto.getLottoNumbers();
            if(lottoNumber.contains(this.bonusNum)) {
                return Rank.SECOND.getBonus();
            }
         return false;
    }

    public double getPercentage() {
        double rewardMoney = 0;
        for(Rank rank : this.rankList) {
            rewardMoney += rank.getReward();
        }
        double profit = rewardMoney / (lottos.size() * 10);
        return profit;
    }

    public List<String> makeAnnounce(List<Rank> rewardList) {
        List<String> announce = new ArrayList<>();
        Rank[] values = Rank.values();
        for(int i=1; i<values.length;i++) {
            announce.add(values[i].getAnnounceMessage() + Collections.frequency(rewardList, values[i])  + "개");
        }
        return announce;
    }


}
