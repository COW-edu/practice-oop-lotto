package lotto.model;

public class Money {
    private static final int NO_BALANCE = 0;
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
        validate(money);
    }

    private void validate(int money) {
        if (money == NO_BALANCE) {
            throw new IllegalArgumentException();
        }

        if ((money % LOTTO_PRICE) != NO_BALANCE) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }

}
