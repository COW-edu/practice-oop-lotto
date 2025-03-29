package lotto.domain;

import lotto.domain.validator.PurchaseAmountValidator;

public class PurchaseAmountManager {
    private int purchaseAmount;

    public void checkPurchaseAmountManager(String inputPurchaseAmount) {
        this.purchaseAmount = PurchaseAmountValidator.validatePurchaseAmount(inputPurchaseAmount);
    }

    public int getLottoCount() {
        return  purchaseAmount/1000;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
