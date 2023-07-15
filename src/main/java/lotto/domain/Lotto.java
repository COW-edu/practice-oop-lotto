package lotto.domain;


import lotto.message.LottoExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = new ArrayList<>(numbers);
  }

  private static final int LOTTO_SIZE = 6;
  private static final int START_INCLUSIVE = 1;
  private static final int END_INCLUSIVE = 45;
  private static final int LOTTO_RANK_5 = 5;


  public List<Integer> getNumbers() {
    return Collections.unmodifiableList(numbers);
  }

  private void validate(List<Integer> numbers) {
    validateNotEnoughSize(numbers);
    validateDuplicate(numbers);
    validateCorrectRange(numbers);
  }

  private void validateNotEnoughSize(List<Integer> numbers) {
    if (numbers.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException(
          LottoExceptionMessage.IS_NOT_ENOUGH_LOTTO_NUMBER.getMessage());
    }
  }

  private void validateDuplicate(List<Integer> numbers) {
    Set<Integer> numbersSet = new HashSet<>(numbers);
    if (numbersSet.size() != numbers.size()) {
      throw new IllegalArgumentException(
          LottoExceptionMessage.IS_DUPLICATE_LOTTO_NUMBER.getMessage());
    }
  }

  private void isCorrectRange(int number) {
    if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
      throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_INCORRECT_RANGE.getMessage());
    }
  }

  private void validateCorrectRange(List<Integer> numbers) {
    numbers.stream()
        .forEach(this::isCorrectRange);
  }

  public int calculateWinningCount(List<Integer> winningLottoNumbersList, int bonusNumber) {
    int winningCount = 0;
    for (int LottoNumber : winningLottoNumbersList) {
      if (numbers.contains(LottoNumber)) {
        winningCount++;
      }
    }
    boolean isBonus = numbers.contains(bonusNumber);
    boolean checkingRank =
        (winningCount == LOTTO_SIZE) || (winningCount == LOTTO_RANK_5 && isBonus);
    if (checkingRank) {
      winningCount++;
    }
    return winningCount;
  }
}
