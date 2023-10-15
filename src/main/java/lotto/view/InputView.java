package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.ErrorMessage;
import lotto.controller.LottoController;

public class InputView {
    private static int LOTTO_NUMBER_RANGE_FIRST = 1;
    private static int LOTTO_NUMBER_RANGE_LAST = 45;

    public InputView() {

    }

    public int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputPurchaseAmount = Integer.parseInt(Console.readLine());
        return inputPurchaseAmount;
    }

    public String inputWinningNum() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        String winningNumberString = Console.readLine();
        return winningNumberString;
    }

    public int inputBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        validateRangeNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateRangeNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_RANGE_FIRST && bonusNumber > LOTTO_NUMBER_RANGE_LAST) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WINNINGNUMBER_UNREASONABLE_RANGE.getErrorMessage());
        }
    }
}
