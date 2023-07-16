package model.lotto;

import java.util.ArrayList;
import java.util.List;

public class PayLottosData {
    private final LottoStore lottoStore;
    private int payMoney;
    private int countOfLotto;
    private List<Lotto> lottos;
    public int getCountOfLotto(){
        return this.countOfLotto;
    }
    public List<Lotto> getLottos(){
        return this.lottos;
    }
    public int getPayMoney(){return this.payMoney;}

    public PayLottosData(){
        lottoStore = new LottoStore();
    }

    public void makeLottoData(int lottoMoney){
        payMoney =lottoMoney;
        countOfLotto=lottoStore.lottoSizeCount(lottoMoney);
        lottos= lottoStore.makeLottoList(lottoMoney);
    }


}
