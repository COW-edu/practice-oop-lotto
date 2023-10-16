package lotto.controller;

import lotto.domain.*;
import lotto.view.input.InputBonusNumber;
import lotto.view.input.InputBuyLottoMoney;
import lotto.view.input.InputWinningNumbers;

import java.util.List;

import static lotto.view.output.OutputLottoCount.printLottoCount;
import static lotto.view.output.OutputLottoList.printLottoList;
import static lotto.view.output.OutputRate.printRate;
import static lotto.view.output.OutputResult.printResult;

public class LottoController {

    public void start() {
        Money money = getBuyLottoMoney();
        printLottoCount(money);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();

        ResultCalculator resultCalculator = new ResultCalculator();
        ResultPrize resultPrize = resultCalculator.calculateResult(winningLotto, lottos);
        printResult(resultPrize);

        double rate = getRate(money, resultPrize);
        printRate(rate);
    }

    private double getRate(Money money, ResultPrize resultPrize) {
        RateCalculator rateCalculator = new RateCalculator();
        return rateCalculator.calculateRate(money, resultPrize);
    }

    private WinningLotto getWinningLotto() {
        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> winningNumbers = inputWinningNumbers.getValue();
        int bonusNumber = inputBonusNumber.getValue();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lottos getLottos(Money money) {
        LottosFactory lottoGenerator = new LottosFactory();
        return new Lottos(lottoGenerator.makeLottos(money));
    }

    private Money getBuyLottoMoney() {
        InputBuyLottoMoney inputBuyLottoMoney = new InputBuyLottoMoney();
        int money = inputBuyLottoMoney.getValue();
        return new Money(money);
    }

}
