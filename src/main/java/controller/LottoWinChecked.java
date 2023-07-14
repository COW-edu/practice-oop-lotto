package controller;

import model.LottosData;
import model.WinData;

import java.util.*;

public class LottoWinChecked {
    private LottosData lottosData;
    private WinData winData;
    private int[] equalCounts;
    private boolean[] bonusCounts;
    public LottoWinChecked(LottosData lottosData, WinData winData){
        this.lottosData=lottosData;
        this.winData=winData;
    }
    public int[] getEqualCounts() {return equalCounts;}

    public boolean[] getBonusCounts() {return bonusCounts;}
    public void checkedWinLottoNums() {
        equalCounts= findEqualCount(winData.getWinLotto().getNumbers());
    }

    public void checkedBonusLottoNums(){
        bonusCounts = checkBonusCount(winData.getBonusNum());
    }
    private boolean[] checkBonusCount(int bonusNum) {
        boolean[] checkBonus = new boolean[lottosData.getCountOfLotto()];
        for(int i=0; i<lottosData.getCountOfLotto(); i++){
            List<Integer> numsOfLotto= lottosData.getLottos().get(i).getNumbers();
            Set<Integer> lottoNumsTemp = new HashSet<>();
            lottoNumsTemp.addAll(numsOfLotto);
            if(lottoNumsTemp.contains(bonusNum)){
                checkBonus[i]=true;
                continue;
            }
            checkBonus[i]=false;
        }
        return checkBonus;
    }
    private int[] findEqualCount(List<Integer> winLottoNums) {
        Set<Integer> winlottoCheckTemp = new HashSet<>();
        winlottoCheckTemp.addAll(winLottoNums);
        int[] equalCounts = new int[lottosData.getCountOfLotto()];
        int count =0;
        return findEqualCount(count,winlottoCheckTemp,equalCounts);
    }

    private int[] findEqualCount(int count, Set<Integer> winlottoCheckTemp, int[] equalCounts) {
        if(count>=lottosData.getCountOfLotto()){
            return equalCounts;
        }
        List<Integer> lottoNums = lottosData.getLottos().get(count).getNumbers();
        for(int j=0; j<lottosData.getCOUNTOFLOTTONUM(); j++){
            if(winlottoCheckTemp.contains(lottoNums.get(j))){
                equalCounts[count]++;
            }
        }
        return findEqualCount(++count, winlottoCheckTemp, equalCounts);
    }

}
