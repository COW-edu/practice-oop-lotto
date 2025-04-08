package model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> result;
    private final double profitRate;
    private final int money;

    public LottoResult(Map<Integer, Integer> result, double profitRate, int money) {
        this.result = result;
        this.profitRate = profitRate;
        this.money = money;
    }

    public Map<Integer, Integer> getResult() {
        return new HashMap<>(result);
    }

    public double getProfitRate() {
        return profitRate;
    }
}