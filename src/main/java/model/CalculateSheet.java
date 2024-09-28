package model;

public class CalculateSheet {
    private static final int LOTTO_PRICE = 1000;

    // 금액을 입력받고 몇 장을 샀는지 확인하는 메서드
    public int buyLotto(int money) {
        if (money%1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money/LOTTO_PRICE;
    }

}
