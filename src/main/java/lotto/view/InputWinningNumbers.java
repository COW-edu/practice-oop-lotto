package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class InputWinningNumbers extends Input {
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> getValue() {

        System.out.println(INPUT_MESSAGE);
        String userInput = input();
        List<Integer> winningNumberList = userInputToWinningNumberList(userInput);
        System.out.println();

        return winningNumberList;
    }

    private void validate(int number) {
        if(number > 45) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        } else if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> userInputToWinningNumberList(String userInput) {
        List<Integer> winningNumberList = new ArrayList<>();

        String[] inputNumbers = userInput.split(",");
        for(String number : inputNumbers) {
            int winningNumber = Integer.parseInt(number);
            validate(winningNumber);
            winningNumberList.add(winningNumber);
        }

        return winningNumberList;
    }
}
