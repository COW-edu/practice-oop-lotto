package Model;

import java.util.List;
import java.util.stream.Collectors;

import static Model.Validator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate_Lotto(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validate_Lotto(List<Integer> numbers){
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
