package lotto.controller;

import lotto.domain.Lotto;
import lotto.message.WinningRankMessage;

import java.util.List;

public interface LottoController {

  int checkPurchasedLottoCounts(int purchaseAmount) throws IllegalArgumentException;

  void createLottoList(int purchasedLottoCounts);

  List<Lotto> findLottoList();

  void insertWinningLottoNumbers(String winningNumbers) throws IllegalArgumentException;

  void insertBonusNumber(int bonusNumber) throws IllegalArgumentException;

  List<Integer> countWinningNumber(int purchasedLottoCounts);

  double calculateTotalWinningMoney(WinningRankMessage resultMessage,
      List<Integer> winningLottoCountList,
      int correctNumberCount);
}
