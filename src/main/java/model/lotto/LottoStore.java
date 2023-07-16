package model.lotto;

import java.util.List;

public class LottoStore {

  public Lotto makeLotto(List<Integer> LottoNum){
    return new Lotto(LottoNum);
  }

}
