package kr.abins.lotto.view;

import camp.nextstep.edu.missionutils.Console;
import kr.abins.lotto.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Reader {

    static String read() {
        final String prompt = Console.readLine().trim();
        System.out.println(prompt);
        return prompt;
    }

//    static int readInt() throws NumberFormatException {
//        return readInt(number -> {});
//    }

    static int readInt(final Consumer<Integer> numberCondition) throws IllegalArgumentException {
        try {
            final int number = Integer.parseInt(read());
            numberCondition.accept(number);
            return number;
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_ONLY_INTEGER);
        }
    }

    static List<Integer> readInts(final Consumer<Integer> numberCondition) throws IllegalArgumentException {
        final String[] eachNumbers = read().split(",");
        final List<Integer> numbers = new ArrayList<>();

        try {
            for (final String rawNumber : eachNumbers) {
                final int number = Integer.parseInt(rawNumber.trim());
                numberCondition.accept(number);
                numbers.add(number);
            }
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_ONLY_INTEGER);
        }

        return numbers;
    }
}
