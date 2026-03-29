package domain;

import enums.ErrorMessage;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Amount(String input) {
        int parsedAmount = parseAmount(input);
        validate(parsedAmount);
        this.amount = parsedAmount;
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validate(int parsedAmount) {
        if (parsedAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PLUS.getMessage());
        }
        if (parsedAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND.getMessage());
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }
}
