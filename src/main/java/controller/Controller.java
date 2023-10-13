package controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.RandomLotto;
import lotto.Reward;
import user.User;
import view.OutputView;
import Enum.Rank;

import java.util.List;

public class Controller {

    private User user;
    private Lotto lotto;
    private List<Lotto> lottos;
    private RandomLotto randomLotto;
    private Lotto selectLotto;
    private OutputView outputView;

    public Controller(User user, RandomLotto randomLotto, OutputView outputView) {
        this.user = user;
        this.randomLotto = randomLotto;
        this.outputView = outputView;
    }

    public void start() {
        // 로또 구매
        outputView.inputMoney();
        int count = user.lottoCount(Integer.parseInt(Console.readLine()));
        outputView.announcePayment(count);

        // 입력 금액에 해당하는 로또 번호 출력
        lottos = randomLotto.makeList(count);
        outputView.announceRandomLottos(lottos);

        // 사용자로부터 당첨 번호 입력 & 입력한 번호로 로또 생성
        outputView.inputLottoNum();
        this.lotto = new Lotto(user.userLottoNumber(user.getUserLotto()));

        // 로또 범위 검증 후 변환
        lotto.checkOutOfRange(this.lotto);
        this.selectLotto = this.lotto;

        // 사용자로부터 보너스 번호 입력
        outputView.inputBonusNum();
        String userBonusStr = user.getUserLottoBonus();

        // 입력한 보너스 번호 검증 후 변환
        int userBonusNumber = lotto.userBonusNum(userBonusStr);
        lotto.checkDuplication(selectLotto, userBonusNumber);

        // 번호 비교 후 당첨금 배분
        Reward reward = new Reward(lottos, count, selectLotto, userBonusNumber);
        List<Rank> rewardList = reward.compareLotto();
        outputView.outputReward(reward.makeAnnounce(rewardList));

        // 수익률 출력
        double profit = reward.getPercentage();
        outputView.announceReward(profit);
    }

}
