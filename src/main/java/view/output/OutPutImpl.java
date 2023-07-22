package view.output;

import java.util.Map;
import message.ResultMessage;
import model.customer.Customer;
import model.lotto.LottoStore;
import model.win.WinLottoCount;

public class OutPutImpl implements Output {

  @Override
  public void outPutMessage(String message) {
    System.out.println(message);
  }

  @Override
  public void outPutBuyLotto(Customer customer) {
    outPutMessage("\n" + customer.getPurchasedLottoCount() + ResultMessage.BUY_COUNT_MESSAGE);
    customer.getPurchasedLottos()
        .forEach(lottoData -> outPutMessage(lottoData));
  }

  @Override
  public void outPutLottoResult(Map<String, Integer> winLottoResult, double profitRate) {
    outPutMessage(ResultMessage.WIN_STATISTICS_MESSAGE);
    outPutMessage(ResultMessage.LINE_DIVIDE);
    for (WinLottoCount winLottoCount : WinLottoCount.values()) {
      outPutMessage(
          winLottoCount.getResultMessage() + winLottoResult.get(winLottoCount.getCount()) + "개");
    }
    outPutMessage(ResultMessage.TOTAL_PROFIT_MESSAGE + profitRate + ResultMessage.PERCENT_MESSAGE);
  }


}
