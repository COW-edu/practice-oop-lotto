package view.output;

import java.util.Map;
import model.customer.Customer;
import model.lotto.LottoStore;

public interface Output {
  void outPutMessage(String message);
  void outPutBuyLotto(Customer customer);
  void outPutLottoResult(Map<String, Integer> winLottoResult, double profitRate);

}
