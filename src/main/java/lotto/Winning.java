package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Winning extends Lotto{
    private List<Integer> numbers;
    private int bonus;
    public Winning(List<Integer> numbers) {
        super(numbers);
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    public int getBonus() {
        return bonus;
    }
}