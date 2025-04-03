package lotto.model;

import lotto.global.Constant;
import lotto.global.Validator;

public class WiningNumber {
    private int[] winingNumber;
    private int bonus;

    public WiningNumber(int[] numbers) {
        Validator.checkDuplication(numbers);
        for(int num : numbers){
            validateRange(num);
        }
        this.winingNumber = numbers;
    }

    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        validateRange(bonus);
        Validator.checkBonusDuplicate(winingNumber, bonus);
        this.bonus = bonus;
    }
    public int[] getWiningNumber() {
        return winingNumber;
    }
    public void setWiningNumber(int[] winingNumber) {
        this.winingNumber = winingNumber;
    }
    private static void validateRange(int num) {
        Validator.checkRange(num, Constant.LottoConstant.LOTTO_MIN, Constant.LottoConstant.LOTTO_MAX);
    }
    
}
