package lotto.view;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.LottoRank;
import lotto.model.Lotto;

public class View {
    private static final String PURCHASED_COUNT_MESSAGE = "개를 구매했습니다.";
    public void showMessage(String message){
        System.out.println(message);
    }
    public void showError(String message){
        System.err.println(message);
    }

    public void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size()+ PURCHASED_COUNT_MESSAGE);
        for(int i=0; i<lottos.size(); i++){
            System.out.println(lottos.get(i).getNumbers());
        }
    }
    public void showLottoResult(float profitRate, Map<LottoRank, Integer> lottoResult) {
        System.out.println(LottoResultFormatter.formatLottoResult(profitRate, lottoResult));
    }
    public String inputString(String str) {
        showMessage(str);
        return Console.readLine();
    }
    
}
