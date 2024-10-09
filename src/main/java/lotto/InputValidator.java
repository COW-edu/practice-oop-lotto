package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoConstants.LOTTO_PRICE;

public class InputValidator {

    public void validateMoney(String input) {
        if (!input.matches("\\d+") || Integer.parseInt(input) < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요. 금액은 1000원 이상이어야 합니다.");
        }
    }

    public void validateWinningCount(String[] tokens) {
        if (tokens.length != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    public void validateRange(int number) {
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public void validateNoDupes(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public void validateBonus(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LottoConstants.LOTTO_NUMBER_MIN || bonusNumber > LottoConstants.LOTTO_NUMBER_MAX || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않는 번호여야 합니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
