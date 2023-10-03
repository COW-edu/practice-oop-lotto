package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Validate.*;

public class WinningNum {
    private final List<Integer> winningNums;

    public WinningNum(String NumbersInput) {
        this.winningNums = parseNums(NumbersInput);
        validate_Lotto(winningNums);
    }

    private void validate_Lotto(List<Integer> winningNums){
        validate_Size(winningNums);
        validate_Range(winningNums);
        validate_Dup(winningNums);
    }

    public List<Integer> getWinningNumbers() {
        return winningNums;
    }

    private List<Integer> parseNums(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] number_Str = input.split(",");
        for (String numberString : number_Str) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
