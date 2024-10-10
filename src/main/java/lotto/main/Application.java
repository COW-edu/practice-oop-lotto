package lotto.main;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.lotto.LottoComparison;
import lotto.lotto.LottoMatchCounter;
import lotto.lotto.MyLottoMaker;
import lotto.lotto.ProfitCalculator;
import lotto.lotto.WinLottoMaker;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        MyLottoMaker myLottoMaker = new MyLottoMaker(inputHandler);
        new OutputHandler(inputHandler, myLottoMaker);

        WinLottoMaker winLottoMaker = new WinLottoMaker(inputHandler);
        LottoMatchCounter lottoMatchCounter = new LottoMatchCounter();
        new LottoComparison(lottoMatchCounter, myLottoMaker, winLottoMaker, inputHandler);

        ProfitCalculator profitCalculator = new ProfitCalculator(lottoMatchCounter, inputHandler);
        new OutputHandler(lottoMatchCounter, profitCalculator);
    }
    
}
