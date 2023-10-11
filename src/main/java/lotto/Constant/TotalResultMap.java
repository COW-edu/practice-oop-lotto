package lotto.Constant;

import java.util.HashMap;
import java.util.Map;

public class TotalResultMap {

    public static Map<String, Integer> getTotalResultMap(int[] totalResult) {
        Map<String, Integer> totalResultMap = new HashMap<>();
        String[] matchingCount = {"One", "Two", "Three", "Four", "Five", "Five_Bonus", "Six"};
        int i = 1;
        for (String str : matchingCount) {
            totalResultMap.put(str, totalResult[i]);
            i++;
        }
        return totalResultMap;
    }
}
