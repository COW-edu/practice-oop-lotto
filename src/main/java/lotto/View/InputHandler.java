package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.ErrorMessage;
import lotto.Model.InputValidator;

public class InputHandler {
    private final InputValidator inputValidator = new InputValidator();

    public int getPurchasingMoney() {
        System.out.println("구입 금액을 입력해주세요");
        int paidMoney = Integer.parseInt(Console.readLine());
        inputValidator.validatePurchasingMoney(paidMoney);
        return paidMoney;
    }

    public String getWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요");
        return Console.readLine();
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            inputValidator.validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
        }
    }
}
