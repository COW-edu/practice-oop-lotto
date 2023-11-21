package Model;

import java.util.List;
import java.util.stream.Collectors;

import static Model.Validator.*;

public class Lotto {

    private Long id;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public void validate_Lotto(){
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
