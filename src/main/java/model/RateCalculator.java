package model;

public class RateCalculator {

    public RateCalculator() {
    }

    public int calculateWinMoney(int threeCount, int fourCount, int fiveCount, int fiveBonusCount, int sixCount) {
        return threeCount *5000 + fourCount *50000 +
                fiveCount *1500000 + fiveBonusCount *30000000
                + sixCount *2000000000;
    }

    public double calculateRate(int inputMoney, int winMoney) {
        double rateReturn = (double) winMoney / inputMoney;
        return Math.round(rateReturn*100.0);
    }
}
