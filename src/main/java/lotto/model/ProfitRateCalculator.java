package lotto.model;

import lotto.global.LottoRank;

import java.util.Map;

public class ProfitRateCalculator {
    private float profitRate;
    public ProfitRateCalculator() {

    }
    public void profitRateCalculate(int money, Map<LottoRank, Integer> lottoResult) {
        float sum = 0;
        for(LottoRank rank : LottoRank.values()){
            sum += rank.getPrize()*lottoResult.get(rank);
        }
        profitRate = sum/(float)money;
    }
    public float getProfitRate() {
        return profitRate;
    }
}
