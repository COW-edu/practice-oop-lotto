package lotto.logic;

import java.util.Map;
import lotto.constant.MatchingNumberCount;

public class Calculator {

    //계산기
    public static int prizeMoney;
    public static double rateOfReturn;
    private static final double PERCENTAGE = 100;

    public double calculate(Map<String, Integer> totalResultMap, int budget) {
        addTotalPrizeMoney(totalResultMap);
        return rating(budget);
    }

    private double rating(int budget) {
        rateOfReturn = (double) prizeMoney / (double) budget * PERCENTAGE; //
        rateOfReturn = Math.round(rateOfReturn) / PERCENTAGE;
        return rateOfReturn;
    }

    public void addTotalPrizeMoney(Map<String, Integer> totalResultMap) {
        for (MatchingNumberCount count : MatchingNumberCount.values()) {
            prizeMoney += count.getWinningPrices(totalResultMap.get(count.name()));
        }
    }
}
