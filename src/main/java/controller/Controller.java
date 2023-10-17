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
    private static int count;

    public Controller(User user, RandomLotto randomLotto, OutputView outputView) {
        this.user = user;
        this.randomLotto = randomLotto;
        this.outputView = outputView;
        this.count = 0;
    }

    public void start() {
        try {
            // 로또 구매
            outputView.inputMoney();
            count = user.lottoCount(Console.readLine());

            outputView.announcePayment(count);

            // 입력 금액에 해당하는 로또 번호 출력
            lottos = randomLotto.makeList(count);
            outputView.announceRandomLottos(lottos);

            // 사용자로부터 당첨 번호 입력 & 입력한 번호로 로또 생성(생성 시 검증)
            outputView.inputLottoNum();
            this.selectLotto = new Lotto(user.userLottoNumber(Console.readLine()));

            // 사용자로부터 보너스 번호 입력
            outputView.inputBonusNum();
            String userBonusStr = user.getUserLottoBonus();

            // 입력한 보너스 번호 검증 후 변환
            int userBonusNumber = this.selectLotto.userBonusNum(userBonusStr);

            // 번호 비교 후 당첨금 배분
            Reward reward = new Reward(lottos, count, selectLotto, userBonusNumber);
            List<Rank> rewardList = reward.compareLotto();
            outputView.outputReward(reward.makeAnnounce(rewardList));

            // 수익률 출력
            double profit = reward.getPercentage();
            outputView.announceReward(profit);
        } catch(IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
        }
    }

}
