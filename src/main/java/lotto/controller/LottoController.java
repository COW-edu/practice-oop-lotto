package lotto.controller;


import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public int checkPurchasedLottoCounts(int purchaseAmount) throws IllegalArgumentException {
        int oneThousand = 1000;
        return lottoService.calculatePurchaseAmount(purchaseAmount, oneThousand);
    }

    public List<List<Integer>> createLottoList(int purchasedLottoCounts) {
        return lottoService.createRandomLottoNumbers(purchasedLottoCounts);
    }

    public List<Integer> insertWinningLottoNumbers(String winningNumbers) throws IllegalArgumentException {
        return lottoService.saveWinningLottoNumbers(winningNumbers);
    }

    public List<Integer> insertBonusNumber(int bonusNumber) throws IllegalArgumentException {
        return lottoService.saveBonusNumber(bonusNumber);
    }

    public int [] countWinningNumber(int purchasedLottoCounts) {
        return lottoService.countingWinningNumber(purchasedLottoCounts);
    }
}
