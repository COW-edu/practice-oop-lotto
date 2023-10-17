package Model;

import static Model.Validator.*;

public class Money {

    private static int money = 0;
    public static final int LOTTO_PRICE = 1000;

    public Money(String money) {
        Money.money = Integer.parseInt(money);
    }

    public static int getMoney() {
        return money;
    }

    public void validate_Money(String money){
        validateMoney(money);
    }

    public static int getAmountOfLotto(){
        return money / LOTTO_PRICE;
    }
}