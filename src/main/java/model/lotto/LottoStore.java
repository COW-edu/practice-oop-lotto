package model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import model.customer.Customer;

public class LottoStore {
  private Customer customer;
  private final LottoStoreService lottoStoreService = new LottoStoreService();

  public Customer enterCustomer(int payMoney){
    customer = new Customer(createPurchaseLottos(payMoney),payMoney);
    return customer;
  }
  public double calculateProfitRate(Lotto winLotto, int bonusNumber) {
    return customer.getProfitRate(createWinLottoResult(winLotto,bonusNumber));
  }
//  private Lotto createLotto() {
//    return lottoStoreService.createLotto();
//  }
  private PurchasedLottos createPurchaseLottos(int payMoney) {
    return lottoStoreService.createPurchaseLottos(payMoney);
  }

  private Map<String, Integer> createWinLottoResult(Lotto winLotto, int bonusNumber) {
    return lottoStoreService.createWinLottoResult(customer,winLotto,bonusNumber);
  }


}
