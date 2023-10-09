package lotto.controller;

import lotto.domain.*;
import lotto.view.InputBonusNumber;
import lotto.view.InputBuyLottoMoney;
import lotto.view.InputWinningNumbers;

import java.util.List;

import static lotto.domain.ResultCalculator.calculateResult;
import static lotto.view.OutputLottoCount.printLottoCount;
import static lotto.view.OutputLottoList.printLottoList;
import static lotto.view.OutputRate.printRate;
import static lotto.view.OutputResult.printResult;

public class LottoController {

    public void start() {
        Money money = getBuyLottoMoney();
        printLottoCount(money);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();

        calculateResult(winningLotto, lottos);
        printResult();

        Rate rate = getRate(money);
        printRate(rate);
    }

    private Rate getRate(Money money) {
        RateCalculator rateCalculator = new RateCalculator();
        double rate = rateCalculator.calculateRate(money);

        return new Rate(rate);
    }

    private WinningLotto getWinningLotto() {
        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> winningNumbers = inputWinningNumbers.getValue();
        int bonusNumber = inputBonusNumber.getValue();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lottos getLottos(Money money) {
        LottoFactory lottoGenerator = new LottoFactory();
        return new Lottos(lottoGenerator.makeLottos(money));
    }

    private Money getBuyLottoMoney() {
        InputBuyLottoMoney inputBuyLottoMoney = new InputBuyLottoMoney();
        int money = inputBuyLottoMoney.getValue();
        return new Money(money);
    }

}
