package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class ResultPrize {

    private final Map<Result, Integer> resultPrize;

    public ResultPrize() {
        resultPrize = new EnumMap<>(Result.class);
    }

    public void initializeResult() {
        for(Result result : Result.values()) {
            resultPrize.put(result, 0);
        }
    }

    public void plusTotalCount(Result result) {
        if (result == null) {
            return;
        }
        resultPrize.merge(result, 1, Integer::sum);
    }

    public Map<Result, Integer> getResultPrize() {
        return resultPrize;
    }

}
