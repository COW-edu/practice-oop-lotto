package lotto.Exception;

public class InputTypeCheck extends IllegalArgumentException {
    //예외처리
    public static String inputInt(String input) {
        if (input.matches("-?\\d+(\\.\\d+)?")) {
            return input;
        }
        try {
            throw new IllegalAccessException("[ERROR] 숫자만 입력 가능합니다.");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
