package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.domain.validator.InputValidator;

public class PurchaseAmount {
    private final int purchaseAmount;
    private static final int LOTTO_PRICE = 1000;

    public PurchaseAmount(String inputPurchaseAmount) {
        this.purchaseAmount = parseAndValidatePurchaseAmount(inputPurchaseAmount);
    }

    private int parseAndValidatePurchaseAmount(String inputPurchaseAmount) {
        InputValidator.validateNotEmpty(inputPurchaseAmount);
        int parsedPurchaseAmount = parsePurchaseAmount(inputPurchaseAmount);
        InputValidator.validateInputPositiveNumber(parsedPurchaseAmount);
        validatePurchaseAmount(parsedPurchaseAmount);
        return parsedPurchaseAmount;
    }

    private int parsePurchaseAmount(String inputPurchaseAmount) {
        try{
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER.getMessage());
        }
    }

    private void validatePurchaseAmount(int parsedPurchaseAmount) {
        if (parsedPurchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISION_LOTTO_PRICE.getMessage());
        }
    }

    public int getLottoCount() {
        return  purchaseAmount/LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}