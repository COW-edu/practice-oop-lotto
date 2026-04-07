package lotto.Controller;

import lotto.Service.Check;

public class LottoController {
    Check check = new Check();

    public boolean checkMoney(int num) {
        return check.checkMoney(num);
    }
}
