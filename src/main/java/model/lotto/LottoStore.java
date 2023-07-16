package model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.win.WinLottoCount;
import model.win.WinLottoResult;

public class LottoStore {
  private static final List<Lotto> lottos = new ArrayList<>();
  private int countOfLotto;

  public List<Lotto> makeLottoList(int payMoney){
    countOfLotto = lottoSizeCount(payMoney);
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

  public PayLottosData makePayLottosData(){
    return new PayLottosData();
  }

  public WinLottoResult makeWinLottoResult(int[] equalCounts, boolean[] bonusCounts){
    return new WinLottoResult(makeWinLottoResultData(equalCounts,bonusCounts));
  }

  private Map<String,Integer> makeWinLottoResultData(int[] equalCounts, boolean[] bonusCounts) {
    Map<String,Integer> winCountTemp = new HashMap<>();
    for(WinLottoCount wincount : WinLottoCount.values()){
      double winNumber =Double.parseDouble(wincount.getCount());
      winCountTemp.put(wincount.getCount(),countWin(winNumber, equalCounts, bonusCounts));
    }
    return winCountTemp;
  }

  private int countWin(double winNumber, int[] equalCounts, boolean[] bonusCounts){
    int count=0;
    boolean isInteger = (winNumber%1==0);
    for(int i = 0; i< countOfLotto; i++){
      if(!isInteger&&equalCounts[i]==(int)winNumber&&bonusCounts[i]){
        count++;
        continue;
      }
      if(isInteger&&equalCounts[i]==winNumber&&bonusCounts[i])continue;
      if(equalCounts[i]==winNumber){
        count++;
      }
    }
    return count;
  }

}
