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
        // 로또 구매
        outputView.inputMoney();
        count = user.lottoCount(Console.readLine());
        outputView.announcePayment(count);
    }

    private void makeRandomLottos() {
        // 입력 금액에 해당하는 로또 번호 출력
        lottos = randomLotto.makeList(count);
        outputView.announceRandomLottos(lottos);
    }

    private void selectLottoNumber() {
        // 사용자로부터 당첨 번호 입력 & 입력한 번호로 로또 생성(생성 시 검증)
        outputView.inputLottoNum();
        this.selectLotto = new Lotto(user.userLottoNumber(Console.readLine()));
    }

    private void selectBonusNumber() {
        // 사용자로부터 보너스 번호 입력
        outputView.inputBonusNum();
        String userBonusStr = user.getUserLottoBonus();

        // 입력한 보너스 번호 검증 후 변환
        userBonusNumber = this.selectLotto.userBonusNum(userBonusStr);
    }

    private void decideReward() {
        // 번호 비교 후 당첨금 배분
        this.reward.setReward(lottos, count, selectLotto, userBonusNumber);
        List<Rank> rewardList = reward.compareLotto();
        outputView.outputReward(reward.makeAnnounce(rewardList));
    }

    private void announceProfit() {
        // 수익률 출력
        double profit = reward.getPercentage();
        outputView.announceReward(profit);
    }

}
