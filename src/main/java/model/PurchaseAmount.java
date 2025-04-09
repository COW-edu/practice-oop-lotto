package model;

import global.enums.ErrorMessage;
import global.enums.MagicNumber;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validatePositive(amount);
        validateMultipleOfLottoPrice(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE.getMessage());
        }
    }

    private void validateMultipleOfLottoPrice(int amount) {
        if (amount % MagicNumber.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }

    public int calculateNumberOfLotto() {
        return amount / MagicNumber.LOTTO_PRICE.getValue();
    }
}
