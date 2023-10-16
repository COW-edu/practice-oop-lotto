package lotto.domain;

public class RateCalculator {

    public double calculateRate(Money money, ResultPrize resultPrize) {
        double initialMoney = money.getMoney();
        double winningAmount = 0;

        for(Result result : Result.values()) {
            winningAmount += resultPrize.getResultPrize().get(result) * result.getPrize();
        }

        return winningAmount / initialMoney * 100;
    }

}
