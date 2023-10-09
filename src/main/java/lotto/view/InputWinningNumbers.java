package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class InputWinningNumbers extends Input {
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> getValue() {
        List<Integer> winningNumberList = new ArrayList<>();

        System.out.println(INPUT_MESSAGE);
        String input = input();
        String[] inputNumbers = input.split(",");
        for(String number : inputNumbers) {
            int winningNumber = Integer.parseInt(number);
            validate(winningNumber);
            winningNumberList.add(winningNumber);
        }
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
}
