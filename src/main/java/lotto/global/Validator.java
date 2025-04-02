package lotto.global;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import lotto.global.Constant.ValidatorConstant;

public class Validator{

    public static void checkNoBlank(String str) throws IllegalArgumentException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(ValidatorConstant.blankError());
        }
    }

    public static void checkNumber(String str) throws IllegalArgumentException{
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidatorConstant.numberError());
        }
    }

    public static void checkDuplication(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : array){
            if(map.containsKey(i)){
                throw new IllegalArgumentException(ValidatorConstant.duplicationError());
            }
            map.put(i, 1);
        }
    }

    public static void checkRange(int number, int min, int max) {
        if(number<min||number>max){
            throw new IllegalArgumentException(ValidatorConstant.rangeError(min, max));
        }
    }

    public static void checkCount(StringTokenizer token, int count) {
        if(token.countTokens()!=count){
            throw new IllegalArgumentException(ValidatorConstant.countError(count));
        }
    }
    public static void checkBonusDuplicate(int[] correctLotto,int bonus) {
        if(Arrays.stream(correctLotto).anyMatch(x -> x == bonus)){
            throw new IllegalArgumentException(ValidatorConstant.bonusDuplicateError());
        }
    }
}