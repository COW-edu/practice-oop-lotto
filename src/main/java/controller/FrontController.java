package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Reward;
import domain.Customer;
import Enum.Rank;
import lotto.Lotto;
import lotto.RandomLotto;
import view.OutputView;

import java.util.List;


public class FrontController {

    private boolean start = true;
    private static int count;
    private static int userBonusNum;
    private static double profit;

    private final Customer customer;
    private final RandomLotto randomLotto;
    private final OutputView outputView;
    private final Reward reward;
    private List<Lotto> lottos;
    private Lotto selectLotto;

    private final CustomerController customerController;
    private final LottoController lottoController;
    private final RewardController rewardController;

    public FrontController(Customer customer, RandomLotto randomLotto, OutputView outputView, Reward reward) {
        this.count = 0;

        this.customer = customer;
        this.randomLotto = randomLotto;
        this.outputView = outputView;
        this.reward = reward;

        this.customerController = new CustomerController(customer);
        this.lottoController = new LottoController();
        this.rewardController = new RewardController(reward);
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
            outputView.inputMoney();
            count = customerController.buyingLotto();
            outputView.announcePayment(count);

            this.lottos = lottoController.makeRandomLottos(randomLotto, count);
            outputView.announceRandomLottos(lottos);
        }
        if(requestNumber.equals("2")) {
            outputView.inputLottoNum();
            this.selectLotto = lottoController.makeCustomerLotto(customerController.selectLottoNumber());
        }
        if(requestNumber.equals("3")) {
            outputView.inputBonusNum();
            this.userBonusNum = lottoController.makeBonusNumber(customerController.selectBonusNumber());

        }
        if(requestNumber.equals("4")) {
            List<Rank> rewardList = rewardController.decideReward(lottos, count, selectLotto, userBonusNum);
            outputView.outputReward(reward.makeAnnounce(rewardList));

            profit = rewardController.announceProfit();
            outputView.announceReward(profit);
        }
        if(requestNumber.equals("5")) {
            this.start = false;
        }
    }
}
