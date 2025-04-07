package lotto.model;

import lotto.global.Constant.*;

public class Wallet {
    private static final int UNIT = 1000;
    private static final int GOLD_MAX = 1000000000;
    private static final String UNIT_MONEY = "원 단위로 입력해주세요.";
    private static final String RANGE_MIN= "부터 ";
    private static final String RANGE_MAX= "까지의 숫자를 입력해주세요.";

    private static String unitError() {
        return ValidatorConstant.ERROR + UNIT + UNIT_MONEY;
    }
    private static String rangeError(int min, int max) {
        return ValidatorConstant.ERROR + min + RANGE_MIN + max + RANGE_MAX;
    }
    private int money;
    private int lottoCount;

    public Wallet(int money) {
        validateUnitMoney(money);
        validateRange(money,UNIT,GOLD_MAX);
        this.money = money;
        lottoCount = this.money / UNIT;
    }
    public int getMoney() {
        return money;
    }
    public int getLottoCount() {
        return lottoCount;
    }
    private void validateUnitMoney(int money){
        if (money % UNIT != 0) {
            throw new IllegalArgumentException(unitError());
        }
    }
    private void validateRange(int number, int min, int max) {
        if(number<min||number>max){
            throw new IllegalArgumentException(rangeError(min, max));
        }
    }
}
