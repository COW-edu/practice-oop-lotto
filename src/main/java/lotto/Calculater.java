package lotto;

public class Calculater {
    private int totalMoney;
    private double rateOfReturn;
    private int budget;

    public double calculate(int[] totalResult, int budget) {
        this.budget = budget;
        totalMoneyAdd(totalResult);
        return rating();
    }

    public double rating() {
        rateOfReturn = (double) totalMoney/ budget * 100; //
        rateOfReturn = Math.round(rateOfReturn * 100) / 100.0;
        return rateOfReturn;
    }

    private int totalMoneyAdd(int[] totalResult) {
        int three = 5000* totalResult[3];
        int four = 50000* totalResult[4];
        int five = 1500000* totalResult[5];
        int fiveBonus = 30000000* totalResult[7];
        int six = 2000000000 * totalResult[6];
        this.totalMoney = three+four+five+fiveBonus+six;
        return totalMoney;
    }
}
