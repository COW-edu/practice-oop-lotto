package model;

import valueObject.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

//
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // String 분리하여 배열에 저장하고 배열을 리턴하는 메서드
    public List<Integer> splitNumbers(String numbers) {
        List<Integer> result = new ArrayList<>();

        String[] number = numbers.split(",");
        for (String num : number) {
            result.add(Integer.parseInt(num));
        }
        return result;
    }
}
