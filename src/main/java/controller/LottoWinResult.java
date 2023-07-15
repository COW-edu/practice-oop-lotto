package controller;

import model.LottosData;
import model.WinData;
import java.util.HashMap;
import java.util.Map;
import model.WinLottoCount;

public class LottoWinResult {
    private final LottosData lottosData;
    private final WinData winData;
    private double profitRateSecondPoint;
    private Map<String,Integer> winCountTemp;
    public LottoWinResult(LottosData lottosData, WinData winData){
        this.lottosData=lottosData;
        this.winData=winData;
    }
    public double getProfitRateSecondPoint() {return profitRateSecondPoint;}

    public Map<String, Integer> getWinCountTemp() {return winCountTemp;}

    public void profitRateCalculate(){
        long profit = profitCalculate();
        long useMoney = lottosData.getUseMoney();
        double profitRate = ((double) profit /useMoney)*1000.0;
       profitRateSecondPoint = Math.round(profitRate)/10.0;
    }

    public void totalWinCounted(WinData winData){
        winCountTemp = new HashMap<>();
        for(WinLottoCount wincount : WinLottoCount.values()){
            double winNum =Double.parseDouble(wincount.getCount());
            winCountTemp.put(wincount.getCount(),countWin(winNum));
        }
    }

    private long profitCalculate() {
        long profitTemp =0;
        for(WinLottoCount wincountdata : WinLottoCount.values()){
            long winningPrice =wincountdata.getLottoWinningPrice();
            long winningCount = winData.getWinCountResult().get(wincountdata.getCount());
            profitTemp += winningPrice*winningCount;
        }
        return profitTemp;
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
