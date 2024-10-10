package model;

import java.util.HashMap;
import java.util.Map;

public class RateCalculatorImpl implements RateCalculator {
    private final Map<Integer, Integer> matchCountStatistics;

    public RateCalculatorImpl(Map<Integer, Integer> matchCountStatistics) {
        this.matchCountStatistics = matchCountStatistics;
    }
    public int calculateWinMoney() {
        return matchCountStatistics.get(3)*5000 + matchCountStatistics.get(4)*50000
                + matchCountStatistics.get(5)*1500000 + matchCountStatistics.get(1)*30000000
                + matchCountStatistics.get(6)*2000000000;
    }
    public double calculateRate(int inputMoney, int winMoney) {
        double rateReturn = (double) winMoney / inputMoney;
        return Math.round(rateReturn*100.0);
    }
}
