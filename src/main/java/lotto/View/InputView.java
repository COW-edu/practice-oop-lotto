package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Controller.LottoController;
import lotto.Service.Check;

public class InputView {

    LottoController lottoController = new LottoController();
    int num;

    // 구입 금액 입력
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                num = Integer.parseInt(Console.readLine());
                if (!lottoController.checkMoney(num)) {
                    throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 금액을 입력해주세요.");
            }
        }

    }
}
