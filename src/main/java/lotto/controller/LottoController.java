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

        Lottos lottos = getLottos(new LottosFactory(), money);
        outputLottoList.printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();

        ResultCalculator resultCalculator = new ResultCalculator();
        ResultPrize resultPrize = resultCalculator.calculateResult(winningLotto, lottos);
        outputResult.printResult(resultPrize);

        RateCalculator rateCalculator = new RateCalculator();
        double rate = rateCalculator.calculateRate(money, resultPrize);
        outputRate.printRate(rate);
    }

    private WinningLotto getWinningLotto() {
        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> winningNumbers = inputWinningNumbers.getValue();
        int bonusNumber = inputBonusNumber.getValue();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lottos getLottos(LottosFactory lottosFactory, Money money) {
        return new Lottos(lottosFactory.makeLottos(money));
    }

    private Money getBuyLottoMoney() {
        InputBuyLottoMoney inputBuyLottoMoney = new InputBuyLottoMoney();

        int money = inputBuyLottoMoney.getValue();

        return new Money(money);
    }

}
