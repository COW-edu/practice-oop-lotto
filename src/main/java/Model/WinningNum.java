package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Model.Validator.*;

public class WinningNum {
    private final List<Integer> winningNums;

    public WinningNum(String NumbersInput) {
        this.winningNums = parseNumbers(NumbersInput);
        validate_Lotto(winningNums);
    }

    private void validate_Lotto(List<Integer> winningNums){
        validateSize(winningNums);
        validateRange(winningNums);
        validateDuplicate(winningNums);
    }

    public List<Integer> getWinningNumbers() {
        return winningNums;
    }

    private List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] number_Str = input.split(",");
        for (String numberString : number_Str) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }
        return sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers){
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
