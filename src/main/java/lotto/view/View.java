package lotto.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.Constant.ViewConstant;
import lotto.global.LottoRank;
import lotto.model.Lotto;

public class View {

    public void showMessage(String message){
        System.out.println(message);
    }
    public void showError(String message){
        System.err.println(message);
    }

    public void printResult(int gold, Map<LottoRank, Integer> lottoResult) {
        float sum = 0;
        System.out.println(ViewConstant.STATISTICS);
        for(LottoRank rank : LottoRank.values()){
            System.out.println(ViewConstant.resultMessage(rank.getPrizeText(),lottoResult.get(rank)));
            sum += rank.getPrize()*lottoResult.get(rank);
        }
        System.out.println(ViewConstant.TOTAL_PROFIT_RATE_PREFIX+ (float)Math.round(sum/gold*1000)/10+ViewConstant.TOTAL_PROFIT_RATE_SUFFIX);
    }

    public void printLotto(ArrayList<Lotto> lottos) {
        System.out.println(lottos.size()+ViewConstant.PURCHASED_COUNT_MESSAGE);
        for(int i=0; i<lottos.size(); i++){
            System.out.println(lottos.get(i).getNumbers());
        }
    }
    public String inputString(String str) {
        showMessage(str);
        return Console.readLine();
    }
    
}
