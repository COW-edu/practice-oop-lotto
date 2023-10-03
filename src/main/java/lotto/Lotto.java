package lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Validate.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate_Lotto(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validate_Lotto(List<Integer> numbers){
        validate_Size(numbers);
        validate_Range(numbers);
        validate_Dup(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return numbers;
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
