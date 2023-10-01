package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningChecker {
    private Winning winning;
    private List<Grade> grades;
    public WinningChecker(Winning winning) {
        this.winning = winning;
        this.grades = new ArrayList<>();
    }
    private int getScore(Lotto lotto) {
        int score = 0;
        List<Integer> numbers = lotto.getNumbers();
        for(int winningNumber : winning.getNumbers()) {
            if(numbers.contains(winningNumber)) {
                score++;
            }
        }
        return score;
    }
    private Grade checkGrade(int score, Lotto lotto) {
        if(score == Grade.FIRST.getScore()) {
            return Grade.FIRST;
        }
        if(score == Grade.SECOND.getScore()) {
            if(checkBonus(lotto)) {
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
    private boolean checkBonus(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        if(numbers.contains(winning.getBonus())) {
            return true;
        }
        return false;
    }
    public void setGrades(Lotto lotto) {
        int a = getScore(lotto);
        this.grades.add(checkGrade(a, lotto));
    }
    public int getGradeQuantity(Grade grade) {
        return Collections.frequency(grades, grade);
    }
}