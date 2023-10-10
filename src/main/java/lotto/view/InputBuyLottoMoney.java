package lotto.view;

public class InputBuyLottoMoney extends Input {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요";

    public int getValue() {
        System.out.println(INPUT_MESSAGE);
        int input = input();
        validate(input);
        System.out.println();
        return input;
    }

    private void validate(int input) {
        if(input == 0) {
            throw new IllegalArgumentException();
        }

        if(input % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }


}
