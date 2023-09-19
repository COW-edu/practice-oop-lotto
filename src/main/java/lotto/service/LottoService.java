package lotto.service;

import lotto.domain.Lotto;

import java.util.List;
import lotto.message.WinningRankMessage;

public interface LottoService {

  int calculatePurchaseAmount(int purchaseAmount) throws IllegalArgumentException;

  void createRandomLottoNumbers(int purchasedLottoCounts);

  List<Lotto> findRandomLottoNumbers();

  void saveWinningLottoNumbers(String winningNumbers) throws IllegalArgumentException;

  void saveBonusNumber(int bonusNumber) throws IllegalArgumentException;

  List<Integer> countWinningNumber(int purchasedLottoCounts);

  double calculateTotalWinningMoney(WinningRankMessage winningRankMessage,
      List<Integer> winningLottoCountList,
      int winningCount);
}
