package view.output;

import java.util.Map;
import message.ResultMessage;
import model.customer.Customer;
import model.lotto.LottoStore;
import model.win.WinLottoCount;

public class OutPutImpl implements Output {

  @Override
  public void outputMessage(String message) {
    System.out.println(message);
  }

  @Override
  public void outputBuyLotto(Customer customer) {
    outputMessage("\n" + customer.getPurchasedLottoCount() + ResultMessage.BUY_COUNT_MESSAGE);
    customer.getPurchasedLottos()
        .forEach(lottoData -> outputMessage(lottoData));
  }

  @Override
  public void outputLottoResult(Map<String, Integer> winLottoResult, double profitRate) {
    outputMessage(ResultMessage.WIN_STATISTICS_MESSAGE);
    outputMessage(ResultMessage.LINE_DIVIDE);
    for (WinLottoCount winLottoCount : WinLottoCount.values()) {
      outputMessage(
          winLottoCount.getResultMessage() + winLottoResult.get(winLottoCount.getCount()) + "개");
    }
    outputMessage(ResultMessage.TOTAL_PROFIT_MESSAGE + profitRate + ResultMessage.PERCENT_MESSAGE);
  }


}
