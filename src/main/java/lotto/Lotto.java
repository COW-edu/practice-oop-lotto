package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    // Lotto 객체를 생성하는 메서드
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 로또 번호 생성
        Collections.sort(numbers); // 번호 오름차순 정렬
        return new Lotto(numbers); // 생성된 번호로 Lotto 객체 생성
    }

    public Lotto(List<Integer> numbers) {
        validateNumber(numbers); // 번호 유효성 검사
        validateRedundancy(numbers); // 번호 중복 검증
        validateRange(numbers); // 번호 범위 검증
        this.numbers = numbers;
    }

    // 번호가 6개인지 검증
    private void validateNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 중복 번호 검증
    private void validateRedundancy(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    // 번호 범위 검증 (리스트 내의 각 숫자를 개별적으로 검증)
    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number); // 각 번호에 대해 범위 검증
        }
    }

    // 범위 검증 메서드를 static으로 변경 (단일 숫자 검증)
    public static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // getter method
    public List<Integer> getNumbers() {
        return numbers;
    }
}
