package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Reward;
import domain.User;
import lotto.Lotto;
import lotto.RandomLotto;
import view.OutputView;

import java.util.List;


public class FrontController {

    private boolean start = true;
    private static int count;
    private static int userBonusNum;

    private final User user;
    private final RandomLotto randomLotto;
    private final OutputView outputView;
    private final Reward reward;
    private List<Lotto> lottos;
    private Lotto selectLotto;

    private final CustomerController customerController;
    private final LottoController lottoController;
    private final RewardController rewardController;

    public FrontController(User user, RandomLotto randomLotto, OutputView outputView, Reward reward) {
        this.count = 0;

        this.user = user;
        this.randomLotto = randomLotto;
        this.outputView = outputView;
        this.reward = reward;

        this.customerController = new CustomerController(outputView, user);
        this.lottoController = new LottoController(outputView);
        this.rewardController = new RewardController(outputView, reward);
    }

    public void run() {
        while(start) {
            this.outputView.customerRequest();
            String requestNumber = Console.readLine();
            service(requestNumber);
        }
    }

    private void service(String requestNumber) {
        if(requestNumber.equals("1")) {
            count = customerController.buyingLotto();
            this.lottos = lottoController.makeRandomLottos(randomLotto, count);
        }
        if(requestNumber.equals("2")) {
            this.selectLotto = customerController.selectLottoNumber();
        }
        if(requestNumber.equals("3")) {
            this.userBonusNum = customerController.selectBonusNumber();
        }
        if(requestNumber.equals("4")) {
            rewardController.decideReward(lottos, count, selectLotto, userBonusNum);
            rewardController.announceProfit();
        }
        if(requestNumber.equals("5")) {
            this.start = false;
        }
    }
}
