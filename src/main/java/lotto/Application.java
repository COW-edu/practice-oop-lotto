// 3주차 코드입니다 2주차로 잘못올려서 다시올립니다 ㅜㅜ

package lotto;

import constant.LottoRank;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            LottoView lottoView = new LottoView();
            LottoService lottoService = new LottoService();
            WinLottoView winLottoView = new WinLottoView();
            BonusLottoView bonusLottoView = new BonusLottoView();
            LottoCalculator lottoCalculator = new LottoCalculator();
            LottoResultView lottoResultView = new LottoResultView();

            int purchaseAmount = lottoView.inputPurchaseAmount();
            List<Lotto> purchasedLotto = lottoService.generateLotto(purchaseAmount);
            lottoView.printPurchaseMessage(purchasedLotto.size());
            lottoView.printPurchasedLotto(purchasedLotto);

            List<Integer> winningNumbers = winLottoView.inputWinningNumbers();
            int bonusNumber = bonusLottoView.inputBonusNumber();
            WinLotto winLotto = new WinLotto(winningNumbers, bonusNumber);
            List<LottoRank> results = lottoCalculator.calculateResults(purchasedLotto, winLotto);

            lottoResultView.printResults(results, purchaseAmount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}