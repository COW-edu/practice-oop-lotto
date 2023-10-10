package Model;

import static Model.Validator.validateMoney;

public class Money {

    private static int money = 0;
    private static final int LOTTO_PRICE = 1000;

    public Money(String money) {
        validateMoney(money);
        Money.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public static int getAmountOfLotto(){
        return money / LOTTO_PRICE;
    }
}
