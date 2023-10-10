package lotto.view;

public class InputBonusNumber extends Input {
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 0;

    public int getValue() {
        System.out.println(INPUT_MESSAGE);
        int inputBonusNumber = Integer.parseInt(input());
        validate(inputBonusNumber);
        return inputBonusNumber;
    }

    private void validate(int number) {
        if(number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        } else if (number < MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
