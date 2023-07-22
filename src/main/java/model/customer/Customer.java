package model.customer;

import java.util.Map;
import model.lotto.Lotto;
import model.lotto.PurchasedLottos;

public class Customer {
  private final PurchasedLottos purchasedLottos;
  private final int payMoney;
  private final CustomerService customerService = new CustomerService();

  public Customer(PurchasedLottos purchasedLottos, int payMoney){
    this.purchasedLottos = purchasedLottos;
    this.payMoney =payMoney;
  }
  
  public long createWinCount(double winNumber, Lotto winLotto, int bonusNumber) {
    return customerService.createWinCount(purchasedLottos,winNumber,winLotto,bonusNumber);
  }

  public double getProfitRate(Map<String, Integer> winLottoResult) {
  }
}
