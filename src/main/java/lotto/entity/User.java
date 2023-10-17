package lotto.entity;

import static lotto.constant.LottoRule.LOTTO_ONE_PRICE;

public class User {

    private int budget;
    private int lottoCount;

    public void setBudget(int budget) {
        budgetCheck(budget);
        this.budget = budget;
        setLottoCount();
    }

    public int getBudget() {
        return this.budget;
    }

    public void setLottoCount() {
        this.lottoCount = budget / LOTTO_ONE_PRICE;
    }

    public void budgetCheck(int budget) {
        if ((budget % LOTTO_ONE_PRICE) == 0) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] " + LOTTO_ONE_PRICE + "원으로 나뉘어 떨어져야합니다.");
    }

    public int getLottoCount() {
        return this.lottoCount;
    }
}
