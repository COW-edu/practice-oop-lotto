package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.view.ExceptionMessage;

public class Lotto {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int LOTTO_SIZE = 6;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		validateOverlap(numbers);
		validateRange(numbers);

		this.numbers = numbers.stream()
			.sorted()
			.collect(Collectors.toList());
	}

	public int countMatch(Lotto winningLotto) {
		return (int)numbers.stream()
			.filter(winningLotto::containNumber)
			.count();
	}

	public boolean containNumber(int number) {

		return numbers.contains(number);
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_SIZE) {
			ExceptionMessage.sizeException();
			throw new IllegalArgumentException();
		}
	}

	private void validateOverlap(List<Integer> numbers) {
		Set<Integer> overlapCheck = new HashSet<>(numbers);

		if (overlapCheck.size() != LOTTO_SIZE) {
			ExceptionMessage.overlapException();
			throw new IllegalArgumentException();
		}
	}

	private void validateRange(List<Integer> numbers) {
		boolean invalidRange = numbers.stream()
			.anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER);

		if (invalidRange) {
			ExceptionMessage.rangeException();
			throw new IllegalArgumentException();
		}
	}
}
