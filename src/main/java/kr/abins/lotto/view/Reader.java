package kr.abins.lotto.view;

import camp.nextstep.edu.missionutils.Console;
import kr.abins.lotto.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Reader {

    public String read() {
        return Console.readLine().trim();
    }

    public int readInt(final Validator<Integer> validator) throws IllegalArgumentException {
        final String rawNumber = read();
        final int number = validator.validate(rawNumber.trim());
        return number;
    }

    public List<Integer> readInts(final Validator<Integer> validator) throws IllegalArgumentException {
        final String[] eachNumbers = read().split(",");
        final List<Integer> numbers = new ArrayList<>();

        for (final String rawNumber : eachNumbers) {
            final int number = validator.validate(rawNumber.trim());
            numbers.add(number);
        }
        return numbers;
    }
}
