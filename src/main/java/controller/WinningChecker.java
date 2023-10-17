package controller;

import model.Grade;
import model.Lotto;
import model.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class WinningChecker {

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
}
