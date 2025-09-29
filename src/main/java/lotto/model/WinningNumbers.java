package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class WinningNumbers {
    private final Set<Integer> winning;
    private final Integer bonus;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.winning = new HashSet<>(numbers);
        this.bonus = null;
    }

    private WinningNumbers(Set<Integer> winning, Integer bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public WinningNumbers withBonus(int bonusNumber) {
        validateNumber(bonusNumber);
        if (winning.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return new WinningNumbers(new HashSet<>(winning), bonusNumber);
    }

    public Rank evaluate(Lotto lotto) {
        int match = 0;
        for (Integer n : lotto.getNumbers()) {
            if (winning.contains(n)) {
                match++;
            }
        }
        boolean bonusMatch = bonus != null && lotto.getNumbers().contains(bonus);
        return Rank.of(match, bonusMatch);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
        for (Integer number : numbers) {
            validateNumber(number);
        }
    }

    private void validateNumber(Integer number) {
        if (number == null || number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}


