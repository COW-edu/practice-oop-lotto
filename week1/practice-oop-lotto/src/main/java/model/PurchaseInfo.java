package model;

import global.Constants;

public class PurchaseInfo implements MModel<Integer> {
    private final int purchasePrice;
    private final int purchaseCount;

    public PurchaseInfo(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.purchaseCount = purchasePrice/ Constants.SINGLE_LOTTO_PRICE;
    }

    @Override
    public Integer getData() {
        return purchaseCount;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }


}
