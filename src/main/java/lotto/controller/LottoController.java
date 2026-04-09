package lotto.controller;

import lotto.domain.*;
import lotto.service.*;
import lotto.view.*;
import lotto.config.*;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }
    public void run() {
        try {
            int money = inputView.inputMoney();
            List<Lotto> lottos = lottoService.buyLottos(money);
            outputView.printLottos(lottos);

            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();

            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            LottoResult result = new LottoResult(lottos, winningLotto);

            outputView.printResult(result, money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
