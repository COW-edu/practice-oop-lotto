package MLotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottosData {
    private final int COUNTOFLOTTONUM =6;
    private final int LOTTOPRICE=1000;
    private final int STARTLOTTONUM =1;
    private final int ENDLOTTONUM = 45;
    private int useMoney;
    private int countOflotto;
    private Lotto lotto;
    private ArrayList<Lotto> lottos;
    private String lottosResult;

    public int getCOUNTOFLOTTONUM() {
        return COUNTOFLOTTONUM;
    }

    public int getLOTTOPRICE() {
        return LOTTOPRICE;
    }

    public int getSTARTLOTTONUM() {
        return STARTLOTTONUM;
    }

    public int getENDLOTTONUM() {
        return ENDLOTTONUM;
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
        countOflotto = useMoney/LOTTOPRICE;
         lottosResult ="";
        for(int i=0; i<countOflotto; i++){
            List<Integer> lottoNums =Randoms.pickUniqueNumbersInRange(STARTLOTTONUM,ENDLOTTONUM,COUNTOFLOTTONUM);
            lotto = new Lotto(lottoNums);
            lottosResult += lotto.toString() +"\n";
            lottos.add(lotto);
        }
    }

    private ArrayList<Lotto> getLottoListTemp(){
        return new ArrayList<Lotto>();
    }


}
