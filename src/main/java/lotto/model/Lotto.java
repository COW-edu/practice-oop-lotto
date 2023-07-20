package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Data.ErrorMessage;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    checkNumberLength(numbers);
    checkRepeatedNumber(numbers);
  }

  private void checkNumberLength(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException(ErrorMessage.ERROR_WIN_NUMBER_LENGTH.getData());
    }
  }

  private void checkRepeatedNumber(List<Integer> numbers) {
    ArrayList<Integer> numbersChecker = new ArrayList<>();
    for (int number : numbers) {
      if (numbersChecker.contains(number)) {
        throw new IllegalArgumentException(ErrorMessage.ERROR_REPEATED_LOTTO_NUMBER.getData());
      }
      numbersChecker.add(number);
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public String getNumbersString() {
    return numbers.toString();
  }
}
