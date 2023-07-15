package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottosData {
    private final int COUNT_OF_LOTTO_NUMBER =6;
    private final int LOTTO_PRICE =1000;
    private final int START_LOTTO_NUMBER =1;
    private final int END_LOTTO_NUMBER = 45;
    private int useMoney;
    private int countOflotto;
    private Lotto lotto;
    private ArrayList<Lotto> lottos;
    private String lottosResult;

    public int getCOUNT_OF_LOTTO_NUMBER() {
        return COUNT_OF_LOTTO_NUMBER;
    }
    public int getLOTTO_PRICE() {
        return LOTTO_PRICE;
    }
    public int getSTART_LOTTO_NUMBER() {
        return START_LOTTO_NUMBER;
    }
    public int getEND_LOTTO_NUMBER() {
        return END_LOTTO_NUMBER;
    }
    public int getCountOfLotto(){
        return this.countOflotto;
    }
    public ArrayList<Lotto> getLottos(){
        return this.lottos;
    }
    public int getUseMoney(){return this.useMoney;}
    public String getLottosResult(){return this.lottosResult;}


    public void makeLottoData(int lottoMoney){
        useMoney=lottoMoney;
        lottos=getLottoListTemp();
        countOflotto = useMoney/ LOTTO_PRICE;
         lottosResult ="";
        for(int i=0; i<countOflotto; i++){
            List<Integer> lottoNumbers =Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER,
                END_LOTTO_NUMBER,
                COUNT_OF_LOTTO_NUMBER);
            lotto = new Lotto(lottoNumbers);
            lottosResult += lotto.toString() +"\n";
            lottos.add(lotto);
        }
    }

    private ArrayList<Lotto> getLottoListTemp(){
        return new ArrayList<Lotto>();
    }


}
