package lotto.main;

import java.util.List;
import java.util.Map;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.lotto.ProfitCalculator;
import lotto.lotto.LottoComparison;
import lotto.lotto.MyLottoMaker;
import lotto.lotto.WinLottoMaker;

public class LottoStarter {

  public void run(){
    int price = InputHandler.getPrice();

    MyLottoMaker myLottoMaker = new MyLottoMaker();
    List<List<Integer>> myLottos = myLottoMaker.makeMyLottos(price);

    String winNumbersAsString = InputHandler.getWinNums();
    List<Integer> winLotto = WinLottoMaker.makeWinLotto(winNumbersAsString);

    int bonusNumber = InputHandler.getBonusNum();

    Map prizeRanking = LottoComparison.compareNums(myLottos, winLotto, bonusNumber);

    double profit = ProfitCalculator.calcProfit(prizeRanking, price);

    OutputHandler.printLottoResult(prizeRanking, profit);
  }

}
