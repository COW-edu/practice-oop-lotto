package lotto;

import java.util.List;
import static lotto.Validate.validate_Money;

public class Money {

    private static int money = 0;
    private static final int lottoPrice = 1000;

    public Money(String money) {
        validate_Money(money);
        Money.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public static int getAmountOfLotto(){
        return money / lottoPrice;
    }
}
