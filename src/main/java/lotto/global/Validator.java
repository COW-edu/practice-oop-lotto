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

    public static void checkCount(StringTokenizer token, int count) {
        if(token.countTokens()!=count){
            throw new IllegalArgumentException(ValidatorConstant.countError(count));
        }
    }

}