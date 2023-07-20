package model.lotto;

import java.util.List;

public class PayLottos {
  private final List<Lotto> payLottos;
  public PayLottos(List<Lotto> payLottos){
    this.payLottos = payLottos;
  }
  public void addLotto(Lotto lotto){
    payLottos.add(lotto);
  }

}
