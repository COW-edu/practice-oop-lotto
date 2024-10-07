package lotto.machine;

import lotto.constant.Constant;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new TreeSet<>(numbers);  // TreeSet으로 정렬된 번호 저장
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constant.ERROR_NUMBER_COUNT);
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Constant.ERROR_INVALID_NUMBER);
            }
        }
        if (new TreeSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(Constant.ERROR_DUPLICATE_NUMBER);
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    // 당첨 번호 파싱 및 검증 처리
    public static List<Integer> parseWinningNumbers(String input) {
        String[] split = input.split(",");
        List<Integer> numbers;

        try {
            numbers = List.of(split).stream()
                    .map(String::trim)  // 공백 제거
                    .map(Integer::parseInt)  // 문자열을 숫자로 변환
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.ERROR_INVALID_NUMBER);
        }

        // 유효성 검사
        Lotto lotto = new Lotto(numbers);
        return lotto.getNumbers().stream().collect(Collectors.toList());
    }

    // 보너스 번호 유효성 검사
    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Constant.ERROR_INVALID_NUMBER);
        }
    }
}
