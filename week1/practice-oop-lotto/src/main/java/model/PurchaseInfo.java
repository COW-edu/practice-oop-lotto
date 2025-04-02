package model;

import global.Constants;

import java.util.AbstractMap;

public class PurchaseInfo implements MModel<AbstractMap.SimpleEntry<Integer, Integer>>{
    private final int purchasePrice;
    private final int purchaseCount;

    public PurchaseInfo(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.purchaseCount = purchasePrice/ Constants.SINGLE_LOTTO_PRICE;
    }

    @Override
    public AbstractMap.SimpleEntry<Integer, Integer> getData() {
        return new AbstractMap.SimpleEntry<>(purchasePrice, purchaseCount);
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
    public int getPurchasePrice() {
        return purchasePrice;
    }


}
