package lotto.domain;

public class Money {
    private static final int MONEY_REMAIN_ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
        validate(money);
    }

    private void validate(int money){
        if(money == MONEY_REMAIN_ZERO) {
            throw new IllegalArgumentException();
        }

        if ((money % LOTTO_PRICE) != MONEY_REMAIN_ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }

}
