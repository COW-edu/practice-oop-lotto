package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoMaker {
    private List<Integer> splitNumber(String userNumber) {
        String[] numberList = userNumber.split(",");
        List<Integer> numbers = new ArrayList<Integer>();
        for(String number : numberList) {
            numbers.add(checkIsNumber(number));
        }
        return numbers;
    }
    private int checkIsNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    private List<Integer> sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
    public Lotto makeLotto(String userNumber) {
        List<Integer> numbers = splitNumber(userNumber);
        numbers = sortNumbers(numbers);
        return new Lotto(numbers);
    }
}
