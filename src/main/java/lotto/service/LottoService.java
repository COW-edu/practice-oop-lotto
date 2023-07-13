package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoService {

  int calculatePurchaseAmount(int purchaseAmount, int oneThousand) throws IllegalArgumentException;

  List<Lotto> createRandomLottoNumbers(int purchasedLottoCounts);

  List<Integer> saveWinningLottoNumbers(String winningNumbers) throws IllegalArgumentException;

  void saveBonusNumber(int bonusNumber) throws IllegalArgumentException;

  int[] countingWinningNumber(int purchasedLottoCounts);
}
