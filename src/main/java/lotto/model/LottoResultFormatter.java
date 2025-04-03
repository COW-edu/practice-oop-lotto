package lotto.model;

import lotto.global.Constant.LottoResultFormatterConstant;
import lotto.global.LottoRank;

import java.util.Map;

public class LottoResultFormatter {
    public static String formatLottoResult(int money, Map<LottoRank, Integer> lottoResult) {
        float sum = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(LottoResultFormatterConstant.STATISTICS+"\n");
        for(LottoRank rank : LottoRank.values()){
            sb.append(LottoResultFormatterConstant.resultMessage(rank.getPrizeText(),lottoResult.get(rank))+"\n");
            sum += rank.getPrize()*lottoResult.get(rank);
        }
        sb.append(LottoResultFormatterConstant.TOTAL_PROFIT_RATE_PREFIX);
        sb.append(round(sum/money*100,2));
        sb.append(LottoResultFormatterConstant.TOTAL_PROFIT_RATE_SUFFIX);
        return sb.toString();
    }

    private static float round(float x, int point) {
        float scale = (float) Math.pow(10, point);
        return Math.round(x * scale) / scale;
    }

}
