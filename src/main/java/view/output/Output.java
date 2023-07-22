package view.output;

import java.util.Map;
import model.customer.Customer;
import model.lotto.LottoStore;

public interface Output {
  void outputMessage(String message);
  void outputBuyLotto(Customer customer);
  void outputLottoResult(Map<String, Integer> winLottoResult, double profitRate);

}
