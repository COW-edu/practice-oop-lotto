package lotto.model;

import lotto.global.Constant;
import lotto.global.Validator;

public class MatchLotto{
    private int[] correctNumbers;
    private int bonus;

    public MatchLotto(int[] numbers) {
        Validator.checkDuplication(numbers);
        for(int num : numbers){
            validateRange(num);
        }
        this.correctNumbers = numbers;
    }

    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        validateRange(bonus);
        Validator.checkBonusDuplicate(correctNumbers, bonus);
        this.bonus = bonus;
    }
    public int[] getCorrectNumbers() {
        return correctNumbers;
    }
    public void setCorrectNumbers(int[] correctNumbers) {
        this.correctNumbers = correctNumbers;
    }
    private static void validateRange(int num) {
        Validator.checkRange(num, Constant.LottoConstant.LOTTO_MIN, Constant.LottoConstant.LOTTO_MAX);
    }
    
}
