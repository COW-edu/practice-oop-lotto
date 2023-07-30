package lotto;

import lombok.RequiredArgsConstructor;
import lotto.lotto.port.in.FinishedLottoUseCase;
import lotto.lotto.port.in.ListLottoUseCase;
import lotto.lotto.port.in.PurchaseLottoUseCase;
import lotto.lotto.port.in.dto.RequestFinishedLotto;
import lotto.view.ApplicationView;

@RequiredArgsConstructor
public class LottoApplication implements Runnable {
    private final ApplicationView applicationView;
    private final PurchaseLottoUseCase purchaseLottoUseCase;
    private final ListLottoUseCase listLottoUseCase;
    private final FinishedLottoUseCase finishedLottoUseCase;

    @Override
    public void run() {
        try {
            // - 새로운 로또 티켓(들)을 구매한다.
            purchaseLottos();

            // - 구매한 로또 티켓(들)을 조회한다.
            listPurchasedLotto();

            // - 로또 회차의 결과를 생성한다.
            finishedLotto();

            // - 구매한 회차의 로또 결과를 조회한다.
            listLottoResult();
        } catch (RuntimeException e) {
            applicationView.printErrorMessage(e.getMessage());
        }

    }

    private void listLottoResult() {
        var allLotto = listLottoUseCase.listAllLotto();
        applicationView.printListLottoReward(allLotto);
    }

    private void finishedLotto() {
        var winningNumbers = applicationView.getWinningNumbers();
        var bonusNumber = applicationView.getBonusNumber();

        var request = new RequestFinishedLotto(winningNumbers, bonusNumber);
        finishedLottoUseCase.finish(request);
    }

    private void listPurchasedLotto() {
        var purchasedLotto = listLottoUseCase.listAllLotto();
        applicationView.printListLotto(purchasedLotto);
    }

    private void purchaseLottos() {
        var purchasePrice = applicationView.getPurchasedPrice();
        purchaseLottoUseCase.purchase(purchasePrice);
    }
}
