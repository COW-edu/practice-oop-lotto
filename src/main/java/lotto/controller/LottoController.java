package lotto.controller;

import lotto.domain.*;
import lotto.view.input.InputBonusNumber;
import lotto.view.input.InputBuyLottoMoney;
import lotto.view.input.InputWinningNumbers;
import lotto.view.output.OutputLottoCount;
import lotto.view.output.OutputLottoList;
import lotto.view.output.OutputRate;
import lotto.view.output.OutputResult;

import java.util.List;

public class LottoController {

    private final OutputLottoCount outputLottoCount = new OutputLottoCount();
    private final OutputLottoList outputLottoList = new OutputLottoList();
    private final OutputResult outputResult = new OutputResult();
    private final OutputRate outputRate = new OutputRate();

    public void start() {
        Money money = getBuyLottoMoney();
        outputLottoCount.printLottoCount(money);

        Lottos lottos = getLottos(money);
        outputLottoList.printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();

        ResultCalculator resultCalculator = new ResultCalculator();
        ResultPrize resultPrize = resultCalculator.calculateResult(winningLotto, lottos);
        outputResult.printResult(resultPrize);

        double rate = getRate(money, resultPrize);
        outputRate.printRate(rate);
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
