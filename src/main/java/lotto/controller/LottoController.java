package lotto.controller;

import lotto.domain.Lotto;
import lotto.message.ResultMessage;

import java.util.List;

public interface LottoController {

  int checkPurchasedLottoCounts(int purchaseAmount) throws IllegalArgumentException;

  List<Lotto> createLottoList(int purchasedLottoCounts);

  List<Integer> insertWinningLottoNumbers(String winningNumbers) throws IllegalArgumentException;

  void insertBonusNumber(int bonusNumber) throws IllegalArgumentException;

  int[] countWinningNumber(int purchasedLottoCounts);

  double calculateTotalWinningMoney(ResultMessage resultMessage, int[] winningLottoCountList,
      int correctNumberCount);
}
