package lotto.logic;

import java.util.Map;

public interface Calculator {

    double calculatePrize(Map<String, Integer> totalResultMap, int budget);
}
