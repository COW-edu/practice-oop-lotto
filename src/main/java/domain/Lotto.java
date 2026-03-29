package domain;

import exception.ErrorMessage.ErrorMessageType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String input) {
        this(parseNumbers(input));
    }

    private static List<Integer> parseNumbers(String input) {
        try{
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_NUMBER.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessageType.NOT_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessageType.LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_SIZE.getMessage());
        }
    }
}
