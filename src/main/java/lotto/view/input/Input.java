package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Input {

    public final static String COMMA = ",";
    public final static Integer LOTTO_PRICE = 1000;

    protected String input() {
        String input = Console.readLine();

        if (input.contains(Input.COMMA)) {
            Arrays.stream(input.split(Input.COMMA))
                    .forEach(this::validate);
            return input;
        }

        validate(input);

        return input;
    }

    private void validate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 입력 값은 숫자여야 합니다.");
        }
    }

}