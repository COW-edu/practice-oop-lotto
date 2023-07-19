package model.lotto;

import java.util.List;


public class PayLottosData {

  private final LottoStore lottoStore;
  private int countOfLotto;
  private List<Lotto> lottos;

  public int getCountOfLotto() {
    return this.countOfLotto;
  }

  public List<Lotto> getLottos() {
    return this.lottos;
  }

  public PayLottosData() {
    lottoStore = new LottoStore();
  }

  public void makeLottoData(int lottoMoney) {
    countOfLotto = lottoStore.lottoSizeCount(lottoMoney);
    lottos = lottoStore.makeLottoList(lottoMoney);
  }

}
