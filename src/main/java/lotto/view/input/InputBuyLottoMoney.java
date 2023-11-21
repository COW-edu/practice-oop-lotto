package lotto.view.input;

public class InputBuyLottoMoney extends Input {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요";
    private static final int NO_BALANCE = 0;

    public int getValue() {
        System.out.println(INPUT_MESSAGE);

        String input = input();
        validateInputForm(input);

        int inputBuyLottoMoney = Integer.parseInt(input);
        validateMoney(inputBuyLottoMoney);

        System.out.println();
        return inputBuyLottoMoney;
    }

    private void validateMoney(int input) {
        if(input == NO_BALANCE) {
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 복권을 구매할 수 있습니다.");
        }

        if((input % Input.LOTTO_PRICE) != NO_BALANCE) {
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 복권을 구매할 수 있습니다.");
        }
    }

    private void validateInputForm(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] : 잘못된 입력 값입니다.");
        }
    }


}
