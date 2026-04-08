package lotto.Controller;

import lotto.Service.Check;

public class LottoController {
    private final Check check = new Check();

    public boolean checkMoney(int num) {
        return check.checkMoney(num);
    }

    public boolean checkNumber(int num) {
        return check.checkNumber(num);
    }
}
 
