package model;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        checkDuplication(numbers, bonus);
        checkBoundary(bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    private void checkDuplication(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다");
        }
    }

    private void checkBoundary(int bonus) {
        if(bonus > 45 || bonus < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다");
        }
    }

    public boolean checkBonus(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(this.bonus);
    }
}
