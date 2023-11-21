package controller;

import domain.Reward;
import lotto.Lotto;
import Enum.Rank;

import java.util.List;

public class RewardController {

    private final Reward reward;
    private List<Rank> rewardList;

    public RewardController(Reward reward) {
        this.reward = reward;
    }

    public List<Rank> decideReward(List<Lotto> lottos, int count, Lotto selectLotto, int userBonusNumber) {
        this.reward.setReward(lottos, count, selectLotto, userBonusNumber);
        this.rewardList = reward.compareLotto();
        return rewardList;
    }

    public double announceProfit() {
        double profit = reward.getPercentage();
        return profit;
    }
}
