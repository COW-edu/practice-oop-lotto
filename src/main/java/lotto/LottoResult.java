package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> result;
    private final double profitRate;

    public LottoResult(Map<Integer, Integer> result, double profitRate) {
        this.result = result;
        this.profitRate = profitRate;
    }

    public Map<Integer, Integer> getResult() {
        return new HashMap<>(result); //
    }

    public double getProfitRate() {
        return profitRate;
    }
}