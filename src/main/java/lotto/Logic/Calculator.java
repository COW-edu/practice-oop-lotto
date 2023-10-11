package lotto.Logic;

import java.util.Map;
import lotto.Constant.MatchingNumberCount;

public class Calculator {
    //계산기
    public static int totalMoney;
    public static double rateOfReturn;

    private static final double PERCENTAGE = 100;

    public static double calculate(Map<String, Integer> totalResultMap, int budget) {
        totalMoneyAdd(totalResultMap);
        return rating(budget);
    }

    public static double rating(int budget) {
        rateOfReturn = (double) totalMoney / budget * PERCENTAGE; //
        rateOfReturn = Math.round(rateOfReturn * PERCENTAGE) / PERCENTAGE;
        return rateOfReturn;
    }

    private static void totalMoneyAdd(Map<String, Integer> totalResultMap) {
        int threePrice = MatchingNumberCount.THREE.getWinningPrices(totalResultMap.get("Three"));
        int fourPrice = MatchingNumberCount.FOUR.getWinningPrices(totalResultMap.get("Four"));
        int fivePrice = MatchingNumberCount.FIVE.getWinningPrices(totalResultMap.get("Five"));
        int five_BonusPrice = MatchingNumberCount.FIVE_BONUS.getWinningPrices(totalResultMap.get("Five_Bonus"));
        int sixPrice = MatchingNumberCount.SIX.getWinningPrices(totalResultMap.get("Six"));
        totalMoney = threePrice + fourPrice + fivePrice + five_BonusPrice + sixPrice;
    }
}
