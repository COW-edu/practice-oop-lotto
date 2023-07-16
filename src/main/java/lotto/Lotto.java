package lotto;
import java.util.List;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        System.out.println(numbers);
    }

    public List<Integer> getLotto(){
        return numbers;
    }
}
