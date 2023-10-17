package lotto.constant;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TotalResultMap {

    public Map<String, Integer> getTotalResultMap(int[] totalResult) {
        String[] matchingCount = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FIVE_BONUS", "SIX"};
        return IntStream
            .range(0, matchingCount.length)
            .boxed()
            .collect(Collectors.toMap(i -> matchingCount[i], i -> totalResult[i]));
    }
}
