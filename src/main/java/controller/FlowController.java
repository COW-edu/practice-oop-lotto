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
        try {
            List<Lotto> lottos = buyLotto();
            WinningLotto winningLotto = makeWinningLotto();
            showResult(lottos, winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private List<Lotto> buyLotto() {
        outputView.requestAmount();
        int amount = inputView.requestAmount();
        List<Lotto> lottos = lottoSeller.buyLottos(amount);
        outputView.showOrder(lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        outputView.requestWinning();
        List<Integer> numbers = inputView.requestWinning();
        outputView.requestBonus();
        int bonus = inputView.requestBonus(numbers);
        return winningLottoFactory.makeWinning(numbers, bonus);
    }

    private void showResult(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Grade> grades = winningChecker.rateGrades(lottos, winningLotto);
        outputView.showResult(grades);
        double reward = winningChecker.checkReward(grades);
        double rewardRate = winningChecker.checkRewardRate(lottos, reward);
        outputView.showRewardRate(rewardRate);
    }
}
