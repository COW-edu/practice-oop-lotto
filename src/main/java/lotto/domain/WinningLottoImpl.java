package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.message.LottoExceptionMessage;

public class WinningLottoImpl implements WinningLotto {

  private static final int START_INCLUSIVE = 1;
  private static final int END_INCLUSIVE = 45;
  private static final int LOTTO_SIZE = 6;
  private static final String DELIMITER = ",";

  private List<Integer> winningNumbers = new ArrayList<>();
  private int bonusNumber;

  @Override
  public void saveWinningNumber(String initialWinningNumber) {
    setWinningNumbers(initialWinningNumber);
  }

  @Override
  public void setBonusNumber(int bonusNumber) {
    isCorrectRange(bonusNumber);
    this.bonusNumber = bonusNumber;
  }

  @Override
  public int getBonusNumber() {
    return bonusNumber;
  }

  @Override
  public int calculateWinningCount(List<Integer> lottoList) {
    int winningCount = 0;

    for (int LottoNumber : winningNumbers) {

      if (lottoList.contains(LottoNumber)) {
        winningCount++;
      }
    }
    return winningCount;
  }

  private void setWinningNumbers(String initialWinningNumber) {
    winningNumbers = Arrays.stream(initialWinningNumber.split(DELIMITER))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    validateNotEnoughSize(winningNumbers);
    validateDuplicate(winningNumbers);
    validateCorrectRange(winningNumbers);
  }

  private void validateNotEnoughSize(List<Integer> winningNumber) {

    if (winningNumber.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException(
          LottoExceptionMessage.IS_NOT_ENOUGH_LOTTO_NUMBER.getMessage());
    }
  }

  private void validateDuplicate(List<Integer> winningNumber) {
    Set<Integer> winningNumberSet = new HashSet<>(winningNumber);

    if (winningNumberSet.size() != winningNumber.size()) {
      throw new IllegalArgumentException(
          LottoExceptionMessage.IS_DUPLICATE_LOTTO_NUMBER.getMessage());
    }
  }

  private void validateCorrectRange(List<Integer> winningNumber) {
    winningNumber.stream()
        .forEach(this::isCorrectRange);
  }

  private void isCorrectRange(int integerLottoNumber) {

    if (integerLottoNumber < START_INCLUSIVE || integerLottoNumber > END_INCLUSIVE) {
      throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_INCORRECT_RANGE.getMessage());
    }
  }
}
