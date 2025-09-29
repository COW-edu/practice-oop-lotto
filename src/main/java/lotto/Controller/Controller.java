package lotto.Controller;

import Domain.LottoResult;
import Domain.LottoTicketMachine;
import Domain.WinningLotto;
import View.InputView;
import View.OutputView;
import java.util.List;
import java.util.ArrayList;
import Domain.Lottos;

public class Controller {
    private final OutputView outputView;
    private final InputView inputView;

    public Controller() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    private int setMoney(){
        return inputView.inputMoney();
        //유효성 검사
    }

    private List<Integer> setNum(){
        //유효성 검사
        String[] arr = inputView.inputNum();
        List<Integer> arr2 = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            arr2.add(Integer.parseInt(arr[i]));
        }
        return arr2;
    }

    private int setBonus(){
        return inputView.inputBonusNum();
    }


    public void run(){
        int money = setMoney();  //구입 금액 입력
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine(money);
        outputView.getHowMany(money);  //구매 개수 출력
        Lottos lottos= lottoTicketMachine.execute();  //로또 번호 생성
        outputView.getLottoNum(lottos.getLottos());  //로또 번호 출력
        List<Integer> winningNum = setNum(); //당첨 번호 입력
        int bonusNum = setBonus();  //보너스 번호 입력
        WinningLotto winningLotto = new WinningLotto(winningNum, bonusNum);
        LottoResult lottoResult = lottos.rankAll(winningLotto);
        outputView.getResult(lottoResult);
        outputView.getYield(lottoResult, money);

    }


}
