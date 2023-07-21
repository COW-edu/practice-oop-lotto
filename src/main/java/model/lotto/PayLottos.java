package model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PayLottos {
  private final List<Lotto> payLottos = new ArrayList<>();

  public void addLotto(Lotto lotto, int payMoney){
    int countOfLotto = payMoney/LottoData.LOTTO_PRICE;
    for(int i=0; i<countOfLotto; i++){
      payLottos.add(lotto);
    }
  }



}
