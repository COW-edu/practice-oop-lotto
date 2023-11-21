package controller;

import domain.Reward;
import lotto.Lotto;
import Enum.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RewardController {

    private final Reward reward;
    private List<Rank> rewardList;
    private List<Lotto> lottos;
    private Lotto selectLotto;
    private int userBonusNumber;
    private List<Rank> rankList;

    public RewardController(Reward reward) {
        this.reward = reward;
        rankList = new ArrayList<>();
    }

    public List<Rank> decideReward(List<Lotto> lottos, Lotto selectLotto, int userBonusNumber) {
        this.lottos = lottos;
        this.selectLotto = selectLotto;
        this.rewardList = compareLotto();
        this.userBonusNumber = userBonusNumber;
        return rewardList;
    }

    public List<Rank> compareLotto() {
        for(Lotto lotto : this.lottos) {
            rankList = addRankList(countResult(lotto), lotto);
        }
        return rankList;
    }

    private List<Rank> addRankList(int rankResult, Lotto lotto) {
        for(Rank rank : Rank.values()) {
            if(rankResult == rank.getCountMatch()) {
                saveRank(rankResult, lotto);
                break;
            }
        }
        return this.rankList;
    }

    private int countResult(Lotto lotto) {
        List<Integer> lottoNumber = lotto.getLottoNumbers();
        return (int) this.selectLotto.getLottoNumbers().stream()
                .filter(selectNumber -> lottoNumber.contains(selectNumber))
                .count();
    }

    private void saveRank(int rankResult, Lotto lotto) {
        if(rankResult == Rank.FIRST.getCountMatch()) {
            this.rankList.add(Rank.FIRST);
        }
        if(rankResult == Rank.SECOND.getCountMatch() && bonusCheck(lotto)) {
            this.rankList.add(Rank.SECOND);
        }
        if(rankResult == Rank.THIRD.getCountMatch() && !bonusCheck(lotto)) {
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

    private boolean bonusCheck(Lotto lotto) {
        List<Integer> lottoNumber = lotto.getLottoNumbers();
        if(lottoNumber.contains(userBonusNumber)) {
            return Rank.SECOND.getBonus();
        }
        return false;
    }

    public double announceProfit() {
        getPercentage();
        return reward.getProfit();
    }

    public void getPercentage() {
        double rewardMoney = 0;
        for(Rank rank : this.rankList) {
            rewardMoney += rank.getReward();
        }
        double profit = rewardMoney / (this.lottos.size() * 10);
        reward.setProfit(profit);
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
