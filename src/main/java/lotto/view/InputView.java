package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

public class InputView {

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

        String winngingNumStr = Console.readLine();
        return winngingNumStr;
    }

    public int inputBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        int inputBonusNum = Integer.parseInt(Console.readLine());
        return inputBonusNum;
    }
}
