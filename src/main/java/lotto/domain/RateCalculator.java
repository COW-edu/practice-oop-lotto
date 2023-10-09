package lotto.domain;

import static lotto.domain.Result.*;

public class RateCalculator {

    public double calculateRate(Money money) {
        double initialMoney = money.getMoney();
        double winningAmount = 0;

        winningAmount += FIRST.getPrize() * FIRST.getTotalCount();
        winningAmount += SECOND.getPrize() * SECOND.getTotalCount();
        winningAmount += THIRD.getPrize() * THIRD.getTotalCount();
        winningAmount += FOURTH.getPrize() * FOURTH.getTotalCount();
        winningAmount += FIFTH.getPrize() * FIFTH.getTotalCount();

        return winningAmount / initialMoney * 100;
    }

}
