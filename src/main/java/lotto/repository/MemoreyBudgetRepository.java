package lotto.repository;

import static lotto.constant.LottoRule.LOTTO_ONE_PRICE;

public class MemoreyBudgetRepository implements BudgetRepository {

    private int budget;
    private int lottoCount;

    @Override
    public void setBudget(int budget) {
        budgetCheck(budget);
        this.budget = budget;
        setLottoCount();
    }

    @Override
    public int getBudget() {
        return this.budget;
    }

    @Override
    public void setLottoCount() {

        this.lottoCount = (budget / LOTTO_ONE_PRICE);
    }

    public void budgetCheck(int budget) {
        if ((budget % LOTTO_ONE_PRICE) == 0) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] " + LOTTO_ONE_PRICE + "원으로 나뉘어 떨어져야합니다.");
    }

    @Override
    public int getLottoCount() {
        return this.lottoCount;
    }
}
