package lotto.repository;

public interface BudgetRepository {

    void setBudget(int budget);

    void setLottoCount();

    int getBudget();

    int getLottoCount();
}
