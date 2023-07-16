package model.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import model.lotto.Lotto;

public class LottosData {
    public static final int COUNT_OF_LOTTO_NUMBER =6;
    public static final int LOTTO_PRICE =1000;
    public static final int START_LOTTO_NUMBER =1;
    public static final int END_LOTTO_NUMBER = 45;
    private int useMoney;
    private int countOfLotto;
    private ArrayList<Lotto> lottos;
    private LottoStore lottoStore;
    public int getCountOfLotto(){
        return this.countOfLotto;
    }
    public ArrayList<Lotto> getLottos(){
        return this.lottos;
    }
    public int getUseMoney(){return this.useMoney;}

    public LottosData(){
        lottoStore = new LottoStore();
    }


    public void makeLottoData(int lottoMoney){
        useMoney=lottoMoney;
        lottos= new ArrayList<>();;
        countOfLotto = useMoney/ LOTTO_PRICE;
        for(int i=0; i< countOfLotto; i++){
            List<Integer> lottoNumbers =Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER,
                END_LOTTO_NUMBER,
                COUNT_OF_LOTTO_NUMBER);
            lottos.add(lottoStore.makeLotto(lottoNumbers));
        }
    }


}
