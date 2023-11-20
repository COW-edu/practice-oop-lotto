package controller;

import domain.Reward;
import lotto.Lotto;
import Enum.Rank;
import view.OutputView;

import java.util.List;

public class RewardController {

    private final Reward reward;
    private final OutputView outputView;

    public RewardController(OutputView outputView, Reward reward) {
        this.reward = reward;
        this.outputView = outputView;
    }

    public void decideReward(List<Lotto> lottos, int count, Lotto selectLotto, int userBonusNumber) {
        this.reward.setReward(lottos, count, selectLotto, userBonusNumber);
        List<Rank> rewardList = reward.compareLotto();
        outputView.outputReward(reward.makeAnnounce(rewardList));
    }

    public void announceProfit() {
        double profit = reward.getPercentage();
        outputView.announceReward(profit);
    }
}
