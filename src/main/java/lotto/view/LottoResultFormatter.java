package lotto.view;

import lotto.global.LottoRank;

import java.util.Map;

public class LottoResultFormatter {
    
    private static final String STATISTICS = "당첨 통계 \n-------";
    private static final String TOTAL_PROFIT_RATE_PREFIX = "총 수익률은 ";
    private static final String TOTAL_PROFIT_RATE_SUFFIX = "%입니다.";
    private static final int DECIMAL_POINT = 2;
    private static String resultMessage(String prizeText, int count) {
        return prizeText+" - "+count+"개";
    }
    
    public static String formatLottoResult(float profitRate, Map<LottoRank, Integer> lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(STATISTICS+"\n");
        for(LottoRank rank : LottoRank.values()){
            sb.append(resultMessage(rank.getPrizeText(),lottoResult.get(rank))+"\n");
        }
        sb.append(TOTAL_PROFIT_RATE_PREFIX);
        sb.append(round(profitRate,DECIMAL_POINT));
        sb.append(TOTAL_PROFIT_RATE_SUFFIX);
        return sb.toString();
    }

    private static float round(float x, int point) {
        float scale = (float) Math.pow(10, point);
        return Math.round(x * scale) / scale;
    }

}
