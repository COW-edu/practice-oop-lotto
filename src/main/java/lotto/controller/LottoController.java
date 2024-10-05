package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import static lotto.view.InputView.inputBonusNumber;
import java.util.List;


public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        purchaseLottos();

        inputWinningNumbers();
    }

    private void purchaseLottos() {
        outputView.printInputLottoPriceMessage();
        int amount = inputView.inputPlayerPrice();
        Lotto.validatePurchaseAmount(amount); //유효성 검사
        lottoService.purchaseLottos(amount);
    }

    private void inputWinningNumbers() {
        outputView.printInputLottoWinningMessage();
        List<Integer> winningNumbers = inputView.inputLottoWinningNum();

        outputView.printInputBonusNumberMessage();
        int bonusNumber = inputBonusNumber();

        lottoService.inputWinningNumbers(winningNumbers, bonusNumber);
    }

}

