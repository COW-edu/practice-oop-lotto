package lotto.model;

import lotto.global.Constant;
import lotto.global.Validator;

import java.util.Arrays;
import java.util.HashMap;

public class WiningNumber {
    private final int[] winingNumber;
    private int bonus;

    public WiningNumber(int[] numbers) {
        validateDuplication(numbers);
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
        validateDuplication(winingNumber);
        this.bonus = bonus;
    }
    public int[] getWiningNumber() {
        return Arrays.copyOf(winingNumber, winingNumber.length);
    }
    private void validateDuplication(int[] numbers){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : numbers){
            if(map.containsKey(i)){
                throw new IllegalArgumentException(Constant.ValidatorConstant.duplicationError());
            }
            map.put(i, 1);
        }
    }
    private void validateRange(int number) {
        int min = Constant.LottoConstant.LOTTO_MIN;
        int max = Constant.LottoConstant.LOTTO_MAX;
        if(number<min||number>max){
            throw new IllegalArgumentException(Constant.ValidatorConstant.rangeError(min, max));
        }
    }
    
}
