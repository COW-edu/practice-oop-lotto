package lotto.domain.validator;

public class PurchaseAmountValidator {
    public static int validatePurchaseAmount(String inputPurchaseAmount) {
        if (inputPurchaseAmount == null || inputPurchaseAmount.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해 주세요.");
        }

        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력 가능합니다.");
        }

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양의 정수여야 합니다.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 구매 가능합니다.");
        }
        return purchaseAmount;
    }
}
