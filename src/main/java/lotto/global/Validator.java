package lotto.global;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import lotto.global.Constant.ValidatorConstant;

public class Validator{
    private static final String NO_BLANK = "공백을 입력하셨습니다.";
    private static final String NUMBER = "숫자를 입력해주세요.";
    private static final String COUNT = "개의 숫자를 입력해주세요.";

    private static String blankError() {
        return ValidatorConstant.ERROR + NO_BLANK;
    }
    private static String countError(int count) {
        return ValidatorConstant.ERROR + count + COUNT;
    }
    private static String numberError() {
        return ValidatorConstant.ERROR + NUMBER;
    }

    public static void checkNoBlank(String str) throws IllegalArgumentException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(blankError());
        }
    }

    public static void checkNumber(String str) throws IllegalArgumentException{
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(numberError());
        }
    }

    public static void checkCount(StringTokenizer token, int count) {
        if(token.countTokens()!=count){
            throw new IllegalArgumentException(countError(count));
        }
    }

}