package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Constant.TotalResultMap;
import lotto.Entity.Lotto;
import lotto.Entity.WinLotto;
import lotto.Exception.BudgetCheck;
import lotto.Exception.InputTypeCheck;
import lotto.Logic.Calculator;
import lotto.Logic.Judgment;
import lotto.Logic.LottoMachine;
import lotto.Output.PrintOut;

public class Counter {
    //Counter 객체

    private final LottoMachine machine;
    private final BudgetCheck budgetCheck;
    private final WinLotto winLotto;
    private final Judgment judgment;
    private ArrayList<Lotto> lottoLists;
    private List<Integer> winningLottos;
    private final PrintOut printOut;
    private int[] totalResult;


    public Counter() {
        this.budgetCheck = new BudgetCheck();
        this.machine = new LottoMachine();
        this.winLotto = new WinLotto();
        this.judgment = new Judgment();
        this.printOut = new PrintOut();
    }

    public void run() {
        System.out.println("구입 금액을 입력해주세요.");
        int budget = Integer.parseInt(InputTypeCheck.inputInt(Console.readLine()));
        int count = budgetCheck.check(budget);
        System.out.println(count + "개를 구매했습니다.");

        lottoLists = machine.playLotto(count);
        printOut.printLottoList(lottoLists);
        System.out.println("당첨 번호를 입력해 주세요.");
        winningLottos = winLotto.drawNumber(Console.readLine().split(","));
        System.out.println("보너스 번호를 입력해 주세요.");
        winningLottos = winLotto.drawBonus(winningLottos, Integer.parseInt(Console.readLine()));
        totalResult = judgment.judgeProduce(lottoLists, winningLottos);
        
        printOut.printResult(totalResult);
        double RateOfReturn = Calculator.calculate(TotalResultMap.getTotalResultMap(totalResult), budget);
        System.out.println("총 수익률은 " + RateOfReturn + "%입니다.");
    }

}