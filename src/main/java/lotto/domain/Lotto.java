package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> set = new HashSet<>(numbers);
            if (set.size() != SIZE){
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            }

        for(int n : numbers) {
            if (n<MIN || n>MAX) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
