package lotto.mainSystem;

import java.util.List;
import java.util.Map;
import lotto.InOutputSystem.InputNums;
import lotto.InOutputSystem.PrintStrings;
import lotto.manageLotto.CalcProfit;
import lotto.manageLotto.CompareLottos;
import lotto.manageLotto.MakeLottoLists;
import lotto.manageLotto.MakeWinLotto;

public class StartLotto {
  public void run(){
    int inputPrice = InputNums.price();

    MakeLottoLists lottoLists = new MakeLottoLists();
    List<List<Integer>> myLottos = lottoLists.makeInputLottoList(inputPrice);

    String winningNums = InputNums.winningNums();
    List<Integer> winLotto = MakeWinLotto.makeWinLotto(winningNums);

    int bonusNum = InputNums.bonusNum();

    Map prize = CompareLottos.compareNums(myLottos, winLotto, bonusNum);

    double profit = CalcProfit.calcProfit(prize, inputPrice);

    PrintStrings.lottoResult(prize, profit);
  }
}
