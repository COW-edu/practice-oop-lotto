package CLotto;

import MLotto.LottosData;
import MLotto.WinData;
import java.util.HashMap;
import java.util.Map;

public class LottoWinResult {
    private LottosData lottosData;
    private WinData winData;
    private double profitRateSecondPoint;
    private Map<String,Integer> winCountTemp;
    public LottoWinResult(LottosData lottosData, WinData winData){
        this.lottosData=lottosData;
        this.winData=winData;
    }
    public double getProfitRateSecondPoint() {return profitRateSecondPoint;}

    public Map<String, Integer> getWinCountTemp() {return winCountTemp;}

    public void profitRateCal(){
        long profit = profitCalculate();
        long useMoney = lottosData.getUseMoney();
        double profitRate = ((double) profit /useMoney)*1000.0;
       profitRateSecondPoint = Math.round(profitRate)/10.0;
    }

    private long profitCalculate() {
        long profitTemp =0;
        for(WinData.WinLottoCount wincountdata : WinData.WinLottoCount.values()){
            long winningPrice =wincountdata.getLottoWinningPrice();
            long winningCount = winData.getWinCountResult().get(wincountdata.getCount());
            profitTemp += winningPrice*winningCount;
        }
        return profitTemp;
    }

    public void totalWinCounted(WinData winData){
       winCountTemp = new HashMap<>();
        for(WinData.WinLottoCount wincount : WinData.WinLottoCount.values()){
            double winNum =Double.parseDouble(wincount.getCount());
            winCountTemp.put(wincount.getCount(),countWin(winNum));
        }
    }
    private int countWin(double winNum){
        int count=0;
        boolean isInteger = (winNum%1==0);
        for(int i = 0; i< lottosData.getCountOfLotto(); i++){
            if(!isInteger&&winData.getEqualCounts()[i]==(int)winNum&&winData.getBonusCounts()[i]){
                count++;
                continue;
            }
            if(isInteger&&winData.getEqualCounts()[i]==winNum&&winData.getBonusCounts()[i])continue;
            if(winData.getEqualCounts()[i]==winNum){
                count++;
            }
        }
        return count;
    }
}
