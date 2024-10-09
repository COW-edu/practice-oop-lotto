// 3주차 코드입니다 2주차로 잘못올려서 다시올립니다 ㅜㅜ

package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constant.ErrorMessage;

import java.util.*;

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
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_SIZE_ERROR);
        }
    }

    private void validateRedundancy(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != countNumber) {
            throw new IllegalArgumentException(ErrorMessage.UNIQUE_NUMBERS_ERROR);
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
            throw new IllegalArgumentException(ErrorMessage.RANGE_NUMBER_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
