package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);

        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> checklist = new ArrayList<>();
        for (int number : numbers){
            if (checklist.contains(number)){
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            }
            checklist.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
