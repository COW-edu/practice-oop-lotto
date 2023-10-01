package lotto;

import java.util.List;

public class Money {

    private final int money;
    private final int lottoPrice = 1000;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public int getAmountOfLotto(){
        return money / lottoPrice;
    }

    private static void validate(String money) {
        if(Integer.parseInt(money)%1000 != 0){
            throw new IllegalArgumentException();
        }
    }
}
