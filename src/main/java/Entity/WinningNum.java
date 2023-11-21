package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Service.Validator.*;

public class WinningNum {
    private static List<Integer> winningNums = null;

    public WinningNum(String NumbersInput) {
        winningNums = parseNumbers(NumbersInput);
    }

    public void validate_Lotto(){
        validateSize(winningNums);
        validateRange(winningNums);
        validateDuplicate(winningNums);
    }

    public static List<Integer> getWinningNumbers() {
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
