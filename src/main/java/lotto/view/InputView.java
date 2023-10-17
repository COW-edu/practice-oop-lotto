package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.ErrorMessage;

public class InputView {
    private static final String INPUT_LOTTO_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static int LOTTO_NUMBER_RANGE_FIRST = 1;
    private static int LOTTO_NUMBER_RANGE_LAST = 45;

    public InputView() {

    }

    public int inputPurchaseMoney() {
        System.out.println(INPUT_LOTTO_MONEY);
        int inputPurchaseAmount = Integer.parseInt(Console.readLine());
        return inputPurchaseAmount;
    }

    public String inputWinningNum() {
        System.out.println("\n" + INPUT_LOTTO_WINNING_NUMBER);

        String winningNumberString = Console.readLine();
        return winningNumberString;
    }

    public int inputBonus() {
        System.out.println("\n" + INPUT_BONUS_NUMBER);
        int bonusNumber = Integer.parseInt(Console.readLine());

        validateRangeNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateRangeNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_RANGE_FIRST && bonusNumber > LOTTO_NUMBER_RANGE_LAST) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_NUMBER_UNREASONABLE_RANGE.getErrorMessage());
        }
    }
}
