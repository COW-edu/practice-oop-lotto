package lotto.model;

import lotto.global.Constant.*;

public class Wallet {
    private static final int UNIT =1000;
    private static final String UNIT_MONEY = "원 단위로 입력해주세요.";
    private static String unitError() {
        return ValidatorConstant.ERROR + UNIT + UNIT_MONEY;
    }

    private int money;
    private int lottoCount;

    public Wallet(int money) {
        checkUnitMoney(money);
        this.money = money;
        lottoCount = this.money / UNIT;
    }
    private void checkUnitMoney(int money){
        if (money % UNIT != 0) {
            throw new IllegalArgumentException(unitError());
        }
    }
    public int getMoney() {
        return money;
    }
    public int getLottoCount() {
        return lottoCount;
    }
}
