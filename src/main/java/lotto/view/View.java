package lotto.view;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.Constant.LottoResultFormatterConstant;
import lotto.model.Lotto;

public class View {

    public void showMessage(String message){
        System.out.println(message);
    }
    public void showError(String message){
        System.err.println(message);
    }

    public void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size()+ LottoResultFormatterConstant.PURCHASED_COUNT_MESSAGE);
        for(int i=0; i<lottos.size(); i++){
            System.out.println(lottos.get(i).getNumbers());
        }
    }
    public String inputString(String str) {
        showMessage(str);
        return Console.readLine();
    }
    
}
