package model;

import valueObject.ErrorMessage;

import java.util.List;

//
public class Lotto {
    private final List<Integer> numbers;
    private ErrorMessage errorMessage = new ErrorMessage();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현



}
