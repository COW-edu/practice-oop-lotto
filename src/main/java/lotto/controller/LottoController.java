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
        boolean isPurchasing = true;
        while (isPurchasing) {
            int amount = inputView.inputPlayerPrice();

            try {
                lottoService.purchaseLottos(amount);
                isPurchasing = false;
            } catch (IllegalArgumentException e) {
                outputView.printInputLottoPriceMessage();
            }
        }
    }

    private void inputWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            outputView.printInputLottoWinningMessage();
            try {
                winningNumbers = inputView.inputLottoWinningNum();
                Lotto lotto = new Lotto(winningNumbers);  // 유효성 검사 수행
                break;
            } catch (IllegalArgumentException e) {

            }
        }
        outputView.printInputBonusNumberMessage();
        int bonusNumber = inputBonusNumber();
        lottoService.inputWinningNumbers(winningNumbers, bonusNumber);
    }

}
