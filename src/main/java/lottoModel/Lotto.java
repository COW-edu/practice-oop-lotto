package lottoModel;

import java.util.*;

public class Lotto implements Iterable<Integer> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력해주세요.");
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
