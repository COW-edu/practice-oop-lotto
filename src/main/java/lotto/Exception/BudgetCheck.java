package lotto.Exception;

public class BudgetCheck {

    private static final int LOTTO_ONE_PRICE = 1000;

    public int check(int budget) {
        if ((budget % LOTTO_ONE_PRICE) == 0) {
            System.out.println();
            return budget / LOTTO_ONE_PRICE;
        }

        try {
            throw new IllegalAccessException("[ERROR] 1000원으로 나뉘어 떨어져야합니다.");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
