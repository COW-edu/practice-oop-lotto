package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    
    public void validatePurchasedAmount(int purchasedAmount) {
        if (purchasedAmount < 1000 || purchasedAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상, 1000원 단위로 입력해주세요");
        }
    }

    public void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        validateDuplicateNumbers(winningNumbers);

        for (Integer num : winningNumbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public void validateBonusNumber(Lotto winningLotto, int bonusNum) {
       if(winningLotto.getNumbers().contains(bonusNum)){
           throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
       }
    }
}
