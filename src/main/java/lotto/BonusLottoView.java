package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BonusLottoView {
    public int inputBonusNumber() {
        String inputBonusNumber = "보너스 번호를 입력해주세요.";
        System.out.println(inputBonusNumber);
        int bonusNumber = Integer.parseInt(Console.readLine());
        Lotto.validateRange(bonusNumber);
        return bonusNumber;
    }
}
