package kr.abins.lotto.model;

import kr.abins.lotto.Constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> numbers() {
        return this.numbers;
    }
}