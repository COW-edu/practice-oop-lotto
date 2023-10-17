package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.GenerateNumbers;

class GenerateNumbersTest {

	@DisplayName("생성된 숫자의 개수는 6개이다.")
	@Test
	void checkGeneratedNumbersCount() {
		List<Integer> generatedNumbers = GenerateNumbers.makeRandomNumbers();
		assertThat(generatedNumbers).hasSize(6);
	}

	@DisplayName("생성된 모든 숫자는 1과 45 사이에 있다.")
	@Test
	void checkGeneratedNumbersRange() {
		List<Integer> generatedNumbers = GenerateNumbers.makeRandomNumbers();
		for (int number : generatedNumbers) {
			assertThat(number).isBetween(1, 45);
		}
	}

	@DisplayName("생성된 모든 숫자는 중복이 없다.")
	@Test
	void checkGeneratedNumbersAreUnique() {
		List<Integer> generatedNumbers = GenerateNumbers.makeRandomNumbers();
		List<Integer> distinctNumbers = generatedNumbers.stream().distinct().collect(Collectors.toList());
		assertThat(generatedNumbers).isEqualTo(distinctNumbers);
	}
}
