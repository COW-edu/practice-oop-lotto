package lotto.view;

public class InputBuyLottoMoney extends Input {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요";

    public int getValue() {
        System.out.println(INPUT_MESSAGE);
        String input = input();
        System.out.println();
        return Integer.parseInt(input);
    }


}
