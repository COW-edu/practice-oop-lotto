package controller;

import model.Grade;
import model.Lotto;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class FlowController {

    private InputView inputView;
    private OutputView outputView;
    private LottoSeller lottoSeller;
    private WinningLottoFactory winningLottoFactory;
    private WinningChecker winningChecker;

    public FlowController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initialize();
    }

    private void initialize() {
        this.lottoSeller = new LottoSeller();
        this.winningLottoFactory = new WinningLottoFactory();
        this.winningChecker = new WinningChecker();
    }

    public void run() {
        outputView.requestAmount();
        int amount = inputView.requestAmount();

        List<Lotto> lottos = lottoSeller.buyLottos(amount);

        outputView.showOrder(lottos);

        outputView.requestWinning();
        List<Integer> numbers = inputView.requestWinning();
        outputView.requestBonus();
        int bonus = inputView.requestBonus(numbers);

        WinningLotto winningLotto = winningLottoFactory.makeWinning(numbers, bonus);

        List<Grade> grades = winningChecker.rateGrades(lottos, winningLotto);
        outputView.showResult(grades);
        double reward = winningChecker.checkReward(grades);
        double rewardRate = winningChecker.checkRewardRate(lottos, reward);
        outputView.showRewardRate(rewardRate);
    }
}
