package model;

import java.util.List;

public class WinningNumbers implements MModel<List<Integer>>{
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers);
    }

    @Override
    public List<Integer> getData() {
        return numbers;
    }
}
