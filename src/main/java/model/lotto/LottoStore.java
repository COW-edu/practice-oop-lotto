package model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
  private static final List<Lotto> lottos = new ArrayList<>();
  public List<Lotto> makeLottoList(int payMoney){
    int countOfLotto = lottoSizeCount(payMoney);

    for(int i=0; i< countOfLotto; i++){
      List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoData.START_LOTTO_NUMBER,
          LottoData.END_LOTTO_NUMBER,
          LottoData.COUNT_OF_LOTTO_NUMBER);
      lottos.add(makeLotto(lottoNumbers));
    }
    return lottos;
  }
  public Lotto makeLotto(List<Integer> LottoNum){
    return new Lotto(LottoNum);
  }
  public int lottoSizeCount(int payMoney){
    return  payMoney / LottoData.LOTTO_PRICE;
  }

}
