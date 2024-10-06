package lotto.main;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.lotto.LottoMatchCounter;
import lotto.lotto.ProfitCalculator;
import lotto.lotto.LottoComparison;
import lotto.lotto.MyLottoMaker;
import lotto.lotto.WinLottoMaker;

public class LottoStarter {

  public void run(){
    InputHandler inputHandler = new InputHandler();
    int price = inputHandler.getPrice();

    MyLottoMaker myLottoMaker = new MyLottoMaker();
    List<List<Integer>> myLottos = myLottoMaker.makeMyLottos(price);

    String winNumbersAsString = inputHandler.getWinNums();
    List<Integer> winLotto = WinLottoMaker.makeWinLotto(winNumbersAsString);

    int bonusNumber = inputHandler.getBonusNum();

    LottoMatchCounter lottoMatchCounter = new LottoMatchCounter();
    LottoComparison lottoComparison = new LottoComparison(lottoMatchCounter);
    lottoComparison.compareNums(myLottos, winLotto, bonusNumber);

    Map<Integer, Integer> prizeRanking = lottoMatchCounter.getPrizeRanking();

    ProfitCalculator profitCalculator = new ProfitCalculator();
    double profitRate = profitCalculator.calcProfit(prizeRanking, price);

    OutputHandler.printLottoResult(prizeRanking, profitRate);
  }

}
