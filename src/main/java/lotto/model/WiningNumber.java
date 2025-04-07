package lotto.model;

import lotto.global.Constant.*;
import lotto.global.Validator;

import java.util.Arrays;
import java.util.HashMap;

public class WiningNumber {

    private static final String DUPLICATION = "중복된 숫자가 있습니다.";
    private static final String RANGE_MIN= "부터 ";
    private static final String RANGE_MAX= "까지의 숫자를 입력해주세요.";
    private static final String BONUS_DUPLICATE = "로또 번호와 중복되는 번호입니다.";
    private static String rangeError(int min, int max) {
        return ValidatorConstant.ERROR + min + RANGE_MIN + max + RANGE_MAX;
    }
    private static String duplicationError() {
        return ValidatorConstant.ERROR + DUPLICATION;
    }
    private static String bonusDuplicateError() {
        return ValidatorConstant.ERROR + BONUS_DUPLICATE;
    }

    private final int[] winingNumber;
    private int bonus;

    public WiningNumber(int[] numbers) {
        validateDuplication(numbers);
        for(int num : numbers){
            validateRange(num,LottoConstant.LOTTO_MIN,LottoConstant.LOTTO_MAX);
        }
        this.winingNumber = numbers;
    }

    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        validateRange(bonus,LottoConstant.LOTTO_MIN,LottoConstant.LOTTO_MAX);
        validateBonusDuplication(bonus);
        this.bonus = bonus;
    }
    public int[] getWiningNumber() {
        return Arrays.copyOf(winingNumber, winingNumber.length);
    }

    private void validateDuplication(int[] numbers){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : numbers){
            if(map.containsKey(i)){
                throw new IllegalArgumentException(duplicationError());
            }
            map.put(i, 1);
        }
    }

    private void validateRange(int number, int min, int max) {
        if(number<min||number>max){
            throw new IllegalArgumentException(rangeError(min, max));
        }
    }

    private void validateBonusDuplication(int bonus) {
        if(Arrays.stream(winingNumber).anyMatch(n -> n == bonus)){
            throw new IllegalArgumentException(duplicationError());
        }
    }
    
}
