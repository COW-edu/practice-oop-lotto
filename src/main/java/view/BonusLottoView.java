package view;

import camp.nextstep.edu.missionutils.Console;
import constant.LottoMessage;
import lotto.Lotto;

public class BonusLottoView {
    public int inputBonusNumber() {
        System.out.println(LottoMessage.INPUT_BONUS_NUMBER);
        int bonusNumber = Integer.parseInt(Console.readLine());
        Lotto.validateRange(bonusNumber);
        return bonusNumber;
    }
}
