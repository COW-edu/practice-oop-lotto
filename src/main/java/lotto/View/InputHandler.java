package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.ErrorMessage;

public class InputHandler {

    public int getPurchasingMoney() {
        System.out.println("구입 금액을 입력해주세요");
        int purchasingMoney = Integer.parseInt(Console.readLine());
        InputValidator.validatePurchasingMoney(purchasingMoney);
        return purchasingMoney;
    }

    public String getWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요");
        return Console.readLine();
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            InputValidator.validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.NOT_A_NUMBER.getMessage());
        }
    }
}
