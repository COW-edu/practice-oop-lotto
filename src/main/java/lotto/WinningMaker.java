package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WinningMaker {
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
    private void checkDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다");
        }
    }
    private void checkBoundary(List<Integer> numbers) {
        if(Collections.max(numbers) > 45 || Collections.min(numbers) < 1) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이여야 합니다");
        }
    }
    private List<Integer> sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
    public Winning makeWinning(String userNumber) {
        List<Integer> numbers = splitNumber(userNumber);
        checkDuplication(numbers);
        checkBoundary(numbers);
        numbers = sortNumbers(numbers);
        return new Winning(numbers);
    }
}
