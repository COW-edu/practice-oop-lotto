package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class WinningCheckController implements Controller{

    private static final LottoRepository lottoRepository = LottoRepository.getInstance();
    private static final WinningLottoRepository winningLottoRepository = WinningLottoRepository.getInstance();

    public List<Grade> rateGrades(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Grade> grades = new ArrayList<>();

        for(Lotto lotto : lottos) {
            int score = rateScore(lotto, winningLotto);
            Grade grade = Grade.checkGrade(score, lotto, winningLotto);

            if(grade != null) {
                grades.add(grade);
            }

        }
        return grades;
    }

    private int rateScore(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = lotto.getNumbers();
        int score = (int) winningLotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        return score;
    }

    public double checkReward(List<Grade> grades) {
        double reward = grades.stream()
                .mapToInt(Grade::getReward)
                .sum();
        return reward;
    }

    public double checkRewardRate(List<Lotto> lottos, double reward) {
        return Math.round((reward / (lottos.size() * 10)) * 100) / 100.0;
    }

    @Override
    public void service(InputView inputView, OutputView outputView) {
        List<Lotto> lottos = lottoRepository.findAll();
        WinningLotto winningLotto = winningLottoRepository.getWinningLotto();
        List<Grade> grades = rateGrades(lottos, winningLotto);
        double reward = checkReward(grades);
        double rewardRate = checkRewardRate(lottos, reward);
        outputView.showResult(grades);
        outputView.showRewardRate(rewardRate);
    }
}
