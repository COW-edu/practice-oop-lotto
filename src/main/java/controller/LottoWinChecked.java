package controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.lotto.LottoData;
import model.lotto.PayLottosData;
import model.win.WinData;

public class LottoWinChecked {
    private PayLottosData lottosData;
    private WinData winData;
    private int[] equalCounts;
    private boolean[] bonusCounts;
    public int[] getEqualCounts() {return equalCounts;}

    public boolean[] getBonusCounts() {return bonusCounts;}

    public void storedData(PayLottosData lottosData, WinData winData){
        this.lottosData =lottosData;
        this.winData = winData;
    }
    public void checkedWinLottoNumbers() {
        equalCounts= findEqualCount(winData.getWinLotto().getNumbers());
    }

    public void checkedBonusLottoNumbers(){
        bonusCounts = checkBonusCount(winData.getBonusNumber());
    }

    private boolean[] checkBonusCount(int bonusNumber) {
        boolean[] checkBonus = new boolean[lottosData.getCountOfLotto()];
        for(int i=0; i<lottosData.getCountOfLotto(); i++){
            List<Integer> numbersOfLotto= lottosData.getLottos().get(i).getNumbers();
            Set<Integer> lottoNumbersTemp = new HashSet<>();
            lottoNumbersTemp.addAll(numbersOfLotto);
            if(lottoNumbersTemp.contains(bonusNumber)){
                checkBonus[i]=true;
                continue;
            }
            checkBonus[i]=false;
        }
        return checkBonus;
    }

    private int[] findEqualCount(List<Integer> winLottoNumbers) {
        Set<Integer> winlottoCheckTemp = new HashSet<>();
        winlottoCheckTemp.addAll(winLottoNumbers);
        int[] equalCounts = new int[lottosData.getCountOfLotto()];
        int count =0;
        return findEqualCount(count,winlottoCheckTemp,equalCounts);
    }

    private int[] findEqualCount(int count, Set<Integer> winlottoCheckTemp, int[] equalCounts) {
        if(count>=lottosData.getCountOfLotto()){
            return equalCounts;
        }
        List<Integer> lottoNumbers = lottosData.getLottos().get(count).getNumbers();
        for(int j=0; j< LottoData.COUNT_OF_LOTTO_NUMBER; j++){
            if(winlottoCheckTemp.contains(lottoNumbers.get(j))){
                equalCounts[count]++;
            }
        }
        return findEqualCount(++count, winlottoCheckTemp, equalCounts);
    }

}
