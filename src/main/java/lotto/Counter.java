package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    private budgetCheck budgetCheck;
    private LottoMachine machine;
    private ArrayList<Lotto> lottoLists;
    private WinLotto winLotto;
    private ResultReader resultReader;
    private List<Integer> winningLottos;
    public Counter(){
        this.budgetCheck = new budgetCheck();
        this.machine = new LottoMachine();
        this.winLotto = new WinLotto();
        this.resultReader = new ResultReader();
    }
    public void run(){
        System.out.println("구입 금액을 입력해주세요.");
        int budget = Integer.parseInt(Console.readLine());
        int count = budgetCheck.check(budget);
        System.out.println(count+"개를 구매했습니다.");
        lottoLists = machine.playLotto(count);
        for(Lotto lotto:lottoLists){
            lotto.print();
        }
        winningLottos = winLotto.draw();
        resultReader.produce(lottoLists,winningLottos,budget);
        // 여기에 판정하는 클래스 객체를 생성하고 싶었다.
    }

}