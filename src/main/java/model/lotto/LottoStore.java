package model.lotto;

import java.util.Map;
import model.customer.Customer;

public class LottoStore {
  private Customer customer;
  private final LottoStoreService lottoStoreService = new LottoStoreService();

  public Customer enterCustomer(int payMoney){
    customer = new Customer(getPurchaseLottos(payMoney),payMoney);
    return customer;
  }
  public double calculateProfitRate(Lotto winLotto, int bonusNumber) {
    return customer.getProfitRate(getWinLottoResult(winLotto,bonusNumber));
  }
//  private Lotto createLotto() {
//    return lottoStoreService.createLotto();
//  }
  private PurchasedLottos getPurchaseLottos(int payMoney) {
    return lottoStoreService.createPurchaseLottos(payMoney);
  }

  private Map<String, Integer> getWinLottoResult(Lotto winLotto, int bonusNumber) {
    return lottoStoreService.createWinLottoResult(customer,winLotto,bonusNumber);
  }


}
