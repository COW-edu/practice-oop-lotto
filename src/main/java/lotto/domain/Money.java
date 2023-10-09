package lotto.domain;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
        validate(money);
    }

    private void validate(int money){
        if(money == ZERO) {
            throw new IllegalArgumentException();
        } else if ((money % THOUSAND) != ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return money / 1000;
    }

}
