package model.lotto;

import java.util.List;
import java.util.Map;
import model.customer.Customer;

public class LottoStore {

  private Customer customer;
  private final LottoStoreService lottoStoreService = new LottoStoreService();

  public Customer enterCustomer(int payMoney) {
    customer = new Customer(getPurchaseLottos(payMoney), payMoney);
    return customer;
  }

  public double calculateProfitRate(Map<String, Integer> winLottoResult) {
    return customer.getProfitRate(winLottoResult);
  }

  public Map<String, Integer> createWinLottoResult(List<Integer> winLottoList, int bonusNumber) {
    return lottoStoreService.createWinLottoResult(customer, createLotto(winLottoList), bonusNumber);
  }

  private PurchasedLottos getPurchaseLottos(int payMoney) {
    return lottoStoreService.createPurchaseLottos(payMoney);
  }

  private Lotto createLotto(List<Integer> numbers) {
    return new Lotto(numbers);
  }
}
