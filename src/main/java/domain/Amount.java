package domain;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Amount(String input) {
        int parsedAmount = Integer.parseInt(input); // 입력값이 String여서 int로 변환
        validate(parsedAmount);                     // 조건 확인
        this.amount = parsedAmount;                 // 필드에 저장
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닌 경우");
        }
    }

    private void validate(int parsedAmount) {
        if (parsedAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력값이 음수인 경우");
        }
        if (parsedAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 입력값이 1000원 단위가 아닌 경우");
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }
}
