package model;

public interface RateCalculator {
    public int calculateWinMoney ();
    public double calculateRate(int inputMoney, int winMoney);
}
