package machine;

import model.win.WinLottoCount;
import model.win.WinLottoResult;

public class ProfitCalculator {
    public double profitRateCalculate(WinLottoResult winLottoResult, int payMoney){
        long profit = profitCalculate(winLottoResult);
        double profitRate = ((double) profit /payMoney)*1000.0;
        return Math.round(profitRate)/10.0;
    }

    private long profitCalculate(WinLottoResult winLottoResult) {
        long profitTemp =0;
        for(WinLottoCount wincountdata : WinLottoCount.values()){
            long winningPrice =wincountdata.getLottoWinningPrice();
            long winningCount = winLottoResult.getValue(wincountdata.getCount());
            profitTemp += winningPrice*winningCount;
        }
        return profitTemp;
    }

}
