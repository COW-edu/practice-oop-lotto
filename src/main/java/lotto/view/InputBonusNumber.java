package lotto.view;

public class InputBonusNumber extends Input {
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int getValue() {
        System.out.println(INPUT_MESSAGE);
        String input = input();
        int bonusNumber = Integer.parseInt(input);
        validate(bonusNumber);
        return bonusNumber;
    }

    private void validate(int number) {
        if(number > 45) {
            throw new IllegalArgumentException();
        } else if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}
