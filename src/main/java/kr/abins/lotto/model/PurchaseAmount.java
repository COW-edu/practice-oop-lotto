package kr.abins.lotto.model;

import kr.abins.lotto.constant.Constants;
import kr.abins.lotto.constant.ErrorMessage;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(final int amount) {
        if (amount <= 0) ErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE.throwSelf();
        if (amount % Constants.LOTTO_PRICE != 0) ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE.throwSelf();
        this.amount = amount;
    }

    public int lottoCount() {
        return this.amount / Constants.LOTTO_PRICE;
    }
}
