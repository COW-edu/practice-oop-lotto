package model;

import lotto.ErrorMessage;

public class LottoCounter {
    private final int money;

    public LottoCounter(String input) {
        try {
            this.money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    public int getCount() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
