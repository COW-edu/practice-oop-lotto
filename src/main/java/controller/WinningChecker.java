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
            Grade grade = checkGrade(score, lotto, winningLotto);

            if(grade != null) {
                grades.add(grade);
            }

        }
        return grades;
    }

    private int rateScore(Lotto lotto, WinningLotto winningLotto) {
        int score = 0;
        List<Integer> numbers = lotto.getNumbers();
        for(int winningNumber : winningLotto.getNumbers()) {
            if(numbers.contains(winningNumber)) {
                score++;
            }
        }
        return score;
    }

    private Grade checkGrade(int score, Lotto lotto, WinningLotto winningLotto) {

        if(score == Grade.FIRST.getScore()) {
            return Grade.FIRST;
        }

        if(score == Grade.SECOND.getScore()) {

            if(checkBonus(lotto, winningLotto)) {
                return Grade.SECOND;
            }

            return Grade.THIRD;
        }

        if(score == Grade.FOURTH.getScore()) {
            return Grade.FOURTH;
        }

        if(score == Grade.FIFTH.getScore()) {
            return Grade.FIFTH;
        }

        return null;
    }

    private boolean checkBonus(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = winningLotto.getBonus();

        if(numbers.contains(bonusNumber)) {
            return true;
        }

        return false;
    }

    public double checkReward(List<Grade> grades) {
        double reward = 0;

        for(Grade grade : grades) {
            reward = reward + grade.getReward();
        }

        return reward;
    }

    public double checkRewardRate(List<Lotto> lottos, double reward) {
        return Math.round((reward / (lottos.size() * 10)) * 100) / 100.0;
    }
}
