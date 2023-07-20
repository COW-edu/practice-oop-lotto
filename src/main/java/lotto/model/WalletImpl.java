package lotto.model;

public class WalletImpl implements Wallet {
    private final int purchasePrice;
    private int purchaseAmount;

    WalletImpl(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        calculatePurchaseAmount();
    }

    @Override
    public int getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    @Override
    public void calculatePurchaseAmount() {
        validate();
        purchaseAmount = purchasePrice / 1000;
    }

    private void validate() {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_PRICE_UNIT.getData());
        }
    }
}
