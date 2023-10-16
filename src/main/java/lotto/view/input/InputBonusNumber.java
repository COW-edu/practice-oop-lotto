package lotto.view.input;

public class InputBonusNumber extends Input {
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 0;

    public int getValue() {
        System.out.println(INPUT_MESSAGE);

        String input = input();
        validateInputForm(input);

        int inputBonusNumber = Integer.parseInt(input);
        validateRange(inputBonusNumber);

        return inputBonusNumber;
    }

    private void validateRange(int number) {
        if(number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] : 1 ~ 45 사이의 번호를 입력해 주세요.");
        }

        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("[ERROR] : 1 ~ 45 사이의 번호를 입력해 주세요.");
        }
    }

    private void validateInputForm(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] : 잘못된 입력 값입니다.");
        }
    }
}
