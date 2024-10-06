// 3주차 코드입니다 2주차로 잘못올려서 다시올립니다 ㅜㅜ

package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private final static int minimumNumber = 1;
    private final static int maximumNumber = 45;
    private final static int countNumber = 6;

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minimumNumber, maximumNumber, countNumber);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public Lotto(List<Integer> numbers) {
        validateNumber(numbers);
        validateRedundancy(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumber(List<Integer> numbers) {
        if (numbers.size() != countNumber) {
            String numbersSizeError = "[ERROR] 로또 번호는 6개여야 합니다.";
            throw new IllegalArgumentException(numbersSizeError);
        }
    }

    private void validateRedundancy(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != countNumber) {
            String uniqueNumbersError = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
            throw new IllegalArgumentException(uniqueNumbersError);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number);
        }
    }

    // 범위 검증 메서드를 static으로 변경 (단일 숫자 검증)
    public static void validateRange(int number) {
        if (number < minimumNumber || number > maximumNumber) {
            String rangeNumberError = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
            throw new IllegalArgumentException(rangeNumberError);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
