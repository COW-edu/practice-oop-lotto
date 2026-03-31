package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            List<Lotto> userLottos = purchaseLottos();
            WinningLotto winningLotto = setupWinningLotto();
            showResult(userLottos, winningLotto);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    private List<Lotto> purchaseLottos() {
        int amount = inputView.readPurchaseAmount();
        List<Lotto> lottos = generateLottos(amount / 1000);
        outputView.printPurchasedLottos(lottos);

        return lottos;
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private WinningLotto setupWinningLotto() {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        Lotto winningTicket = new Lotto(winningNumbers);

        int bonusNumber = inputView.readBonusNumber();

        return new WinningLotto(winningTicket, bonusNumber);
    }

    private void showResult(List<Lotto> userLottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult(userLottos, winningLotto);

        outputView.printWinningStatistics(result.getResults());
        outputView.printYield(result.calculateYield());
    }
}