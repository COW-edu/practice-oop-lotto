package lotto.view.input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputWinningNumbers extends Input {
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 0;

    public List<Integer> getValue() {

        System.out.println(INPUT_MESSAGE);
        String inputWinningNumber = input();
        List<Integer> winningNumberList = userInputToWinningNumberList(inputWinningNumber);
        validateDuplicateNumber(winningNumberList);
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

    private void validateDuplicateNumber(List<Integer> winningNumberList) {
            Set<Integer> uniqueNumbers = new HashSet<>();

        winningNumberList.stream()
                    .filter(winningNumber -> !uniqueNumbers.add(winningNumber))
                    .findAny()
                    .ifPresent(duplicateNumber -> {
                        throw new IllegalArgumentException("[ERROR] : 로또 번호에 중복된 숫자가 있습니다.");
                    });
    }

    private List<Integer> userInputToWinningNumberList(String userInput) {
        return Arrays.stream(userInput.split(Input.COMMA))
                .map(Integer::parseInt)
                .peek(this::validate)
                .collect(Collectors.toList());
    }
}
