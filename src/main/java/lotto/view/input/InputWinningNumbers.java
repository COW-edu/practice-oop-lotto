package lotto.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputWinningNumbers extends Input {
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 0;

    public List<Integer> getValue() {

        System.out.println(INPUT_MESSAGE);
        String inputWinningNumber = input();
        List<Integer> winningNumberList = userInputToWinningNumberList(inputWinningNumber);
        System.out.println();

        return winningNumberList;
    }

    private void validate(int number) {
        if(number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] : 1 ~ 45 사이의 번호를 입력해 주세요.");
        }

        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("[ERROR] : 1 ~ 45 사이의 번호를 입력해 주세요.");
        }
    }

    private List<Integer> userInputToWinningNumberList(String userInput) {
        return Arrays.stream(userInput.split(Input.COMMA))
                .map(Integer::parseInt)
                .peek(this::validate)
                .collect(Collectors.toList());
    }
}
