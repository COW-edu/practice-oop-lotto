package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoService {

  int calculatePurchaseAmount(int purchaseAmount, int oneThousand) throws IllegalArgumentException;

  void createRandomLottoNumbers(int purchasedLottoCounts);

  List<Lotto> findRandomLottoNumbers();

  void saveWinningLottoNumbers(String winningNumbers) throws IllegalArgumentException;

  void saveBonusNumber(int bonusNumber) throws IllegalArgumentException;

  int[] countingWinningNumber(int purchasedLottoCounts);
}
