package view.output;

import message.ResultMessage;
import model.lotto.PayLottosData;
import model.win.WinLottoCount;
import model.win.WinLottoResult;

public class OutPutImpl implements Output{
    @Override
    public void outPutMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void outPutLottoResult(double profitRate, WinLottoResult winLottoResult) {
        outPutMessage(ResultMessage.WIN_STATISTICS_MESSAGE);
        outPutMessage(ResultMessage.LINE_DIVIDE);
        for(WinLottoCount winLottoCount : WinLottoCount.values()){
            outPutMessage(winLottoCount.getResultMessage()+winLottoResult.getValue(winLottoCount.getCount())+"개");
        }
        outPutMessage(ResultMessage.TOTAL_PROFIT_MESSAGE+profitRate+ResultMessage.PERCENT_MESSAGE);
    }

    @Override
    public void outPutBuyLotto(PayLottosData lottosData) {
        outPutMessage("\n"+lottosData.getCountOfLotto()+ResultMessage.BUY_COUNT_MESSAGE);
        lottosData.getLottos()
            .forEach(lotto -> outPutMessage(String.valueOf(lotto)));
    }
}
