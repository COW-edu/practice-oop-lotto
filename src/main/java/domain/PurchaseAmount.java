package domain;

import static global.Constants.LOTTO_PRICE;
import enums.ErrorMessage;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PLUS.getMessage());
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND.getMessage());
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }
}
