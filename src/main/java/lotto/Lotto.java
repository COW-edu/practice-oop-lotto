package lotto;

import java.util.*;
//외부에서 들어온 숫자가 맞나만 관리하면 된다.
public class Lotto implements Iterable<Integer> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
