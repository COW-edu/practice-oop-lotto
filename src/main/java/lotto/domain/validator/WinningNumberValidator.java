package lotto.domain.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumberValidator {
    public static List<Integer> validateWinningNumbers(String inputWinningNumbers) {
        if (inputWinningNumbers == null || inputWinningNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해 주세요.");
        }

        if (!inputWinningNumbers.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분해야 합니다.");
        }

        List<Integer> winningNumbers;
        try {
            winningNumbers = Arrays.stream(inputWinningNumbers.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
        }

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]당첨 번호 6개를 입력하세요.");
        }

        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR]로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        // 중복된 숫자가 잇을 경우 예외처리
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 없이 입력해야 합니다.");
        }

        return winningNumbers;
    }
}
