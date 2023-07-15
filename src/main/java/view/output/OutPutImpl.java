package view.output;

import message.ResultMessage;
import model.LottosData;
import model.WinData;
import model.WinLottoCount;

public class OutPutImpl implements Output{
    @Override
    public void outPutMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void outPutLottoResult(WinData winData) {
        outPutMessage(ResultMessage.WIN_STATISTICS_MESSAGE);
        outPutMessage(ResultMessage.LINE_DIVIDE);
        for(WinLottoCount winLottoCount : WinLottoCount.values()){
            outPutMessage(winLottoCount.getResultMessage()+winData.getWinCountResult().get(winLottoCount.getCount())+"개");
        }
        outPutMessage(ResultMessage.TOTAL_PROFIT_MESSAGE+winData.getProfitRateSecondPoint()+ResultMessage.PERCENT_MESSAGE);
    }

    @Override
    public void outPutBuyLotto(LottosData lottosData) {
        outPutMessage("\n"+lottosData.getCountOfLotto()+ResultMessage.BUY_COUNT_MESSAGE);
        outPutMessage(lottosData.getLottosResult());
    }
}
