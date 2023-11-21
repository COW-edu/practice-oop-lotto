package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Reward;
import domain.Customer;
import Enum.Rank;
import lotto.Lotto;
import view.OutputView;

import java.util.List;


public class FrontController {

    private boolean start = true;
    private static int count;
    private static double profit;

    private final OutputView outputView;
    private List<Lotto> lottos;
    private Lotto selectLotto;
    private int userBonusNum;

    private final CustomerController customerController;
    private final LottoController lottoController;
    private final RewardController rewardController;

    public FrontController(Customer customer, OutputView outputView, Reward reward) {
        this.count = 0;

        this.outputView = outputView;

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

            this.lottos = lottoController.makeRandomLottos(count);
            outputView.announceRandomLottos(lottos);
        }
        if(requestNumber.equals("2")) {
            outputView.inputLottoNum();
            this.selectLotto = lottoController.makeCustomerLotto(customerController.selectLottoNumber());
        }
        if(requestNumber.equals("3")) {
            outputView.inputBonusNum();
            this.userBonusNum = customerController.selectBonusNumber();
        }
        if(requestNumber.equals("4")) {
            List<Rank> rewardList = rewardController.decideReward(lottos, selectLotto, userBonusNum);
            outputView.outputReward(rewardController.makeAnnounce(rewardList));

            profit = rewardController.announceProfit();
            outputView.announceReward(profit);
        }
        if(requestNumber.equals("5")) {
            this.start = false;
        }
    }
}
