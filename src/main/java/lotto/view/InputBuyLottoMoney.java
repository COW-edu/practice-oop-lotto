package lotto.view;

public class InputBuyLottoMoney extends Input {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요";
    private static final int ZERO = 0;

    public int getValue() {
        System.out.println(INPUT_MESSAGE);
        int input = Integer.parseInt(input());
        validate(input);
        System.out.println();
        return input;
    }

    private void validate(int input) {
        if(input == ZERO) {
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 복권을 구매할 수 있습니다.");
        }

        if((input % 1000) != ZERO) {
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 복권을 구매할 수 있습니다.");
        }
    }


}
