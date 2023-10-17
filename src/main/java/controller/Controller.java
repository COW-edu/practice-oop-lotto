package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.User;
import lotto.Lotto;
import lotto.RandomLotto;
import domain.Reward;
import view.OutputView;
import Enum.Rank;

import java.util.List;

public class Controller {

    private final User user;
    private final RandomLotto randomLotto;
    private final OutputView outputView;

    private List<Lotto> lottos;
    private Lotto selectLotto;
    private Reward reward;
    private static int userBonusNumber;
    private static int count;

    public Controller(User user, RandomLotto randomLotto, OutputView outputView, Reward reward) {
        this.user = user;
        this.randomLotto = randomLotto;
        this.outputView = outputView;
        this.reward = reward;
        this.count = 0;
    }

    public void start() {
        try {
            buyingLotto();
            makeRandomLottos();
            selectLottoNumber();
            selectBonusNumber();
            decideReward();
            announceProfit();
        } catch(IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
        }
    }

    private void buyingLotto() {
        outputView.inputMoney();
        count = user.lottoCount(Console.readLine());
        outputView.announcePayment(count);
    }

    private void makeRandomLottos() {
        lottos = randomLotto.makeList(count);
        outputView.announceRandomLottos(lottos);
    }

    private void selectLottoNumber() {
        outputView.inputLottoNum();
        this.selectLotto = new Lotto(user.userLottoNumber(Console.readLine()));
    }

    private void selectBonusNumber() {
        outputView.inputBonusNum();
        String userBonusStr = user.getUserLottoBonus();
        userBonusNumber = this.selectLotto.userBonusNum(userBonusStr);
    }

    private void decideReward() {
        this.reward.setReward(lottos, count, selectLotto, userBonusNumber);
        List<Rank> rewardList = reward.compareLotto();
        outputView.outputReward(reward.makeAnnounce(rewardList));
    }

    private void announceProfit() {
        double profit = reward.getPercentage();
        outputView.announceReward(profit);
    }

}
