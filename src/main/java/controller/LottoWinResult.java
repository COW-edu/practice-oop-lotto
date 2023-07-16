package controller;

import model.lotto.PayLottosData;
import model.win.WinData;
import java.util.HashMap;
import java.util.Map;
import model.win.WinLottoCount;

public class LottoWinResult {
    private PayLottosData lottosData;
    private WinData winData;
    private double profitRateSecondPoint;
    private Map<String,Integer> winCountTemp;
    public double getProfitRateSecondPoint() {return profitRateSecondPoint;}

    public Map<String, Integer> getWinCountTemp() {return winCountTemp;}

    public void storedData(PayLottosData lottosData, WinData winData){
        this.lottosData =lottosData;
        this.winData =winData;
    }
    public void profitRateCalculate(){
        long profit = profitCalculate();
        long useMoney = lottosData.getPayMoney();
        double profitRate = ((double) profit /useMoney)*1000.0;
       profitRateSecondPoint = Math.round(profitRate)/10.0;
    }

    public void totalWinCounted(){
        winCountTemp = new HashMap<>();
        for(WinLottoCount wincount : WinLottoCount.values()){
            double winNumber =Double.parseDouble(wincount.getCount());
            winCountTemp.put(wincount.getCount(),countWin(winNumber));
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

    private int countWin(double winNumber){
        int count=0;
        boolean isInteger = (winNumber%1==0);
        for(int i = 0; i< lottosData.getCountOfLotto(); i++){
            if(!isInteger&&winData.getEqualCounts()[i]==(int)winNumber&&winData.getBonusCounts()[i]){
                count++;
                continue;
            }
            if(isInteger&&winData.getEqualCounts()[i]==winNumber&&winData.getBonusCounts()[i])continue;
            if(winData.getEqualCounts()[i]==winNumber){
                count++;
            }
        }
        return count;
    }
}
