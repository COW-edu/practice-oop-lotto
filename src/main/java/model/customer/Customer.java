package model.customer;

import java.util.Map;
import model.lotto.Lotto;
import model.lotto.PurchasedLottos;
import model.win.WinLottoCount;

public class Customer {
  private final PurchasedLottos purchasedLottos;
  private final int payMoney;
  private final CustomerService customerService = new CustomerService();

  public Customer(PurchasedLottos purchasedLottos, int payMoney){
    this.purchasedLottos = purchasedLottos;
    this.payMoney = payMoney;
  }
  
  public long getWinCount(double winNumber, Lotto winLotto, int bonusNumber) {
    return customerService.createWinCount(purchasedLottos,winNumber,winLotto,bonusNumber);
  }

  public double getProfitRate(Map<String, Integer> winLottoResult) {
    return customerService.createProfitRate(winLottoResult,payMoney);
  }
}
