package modelCreator;

import model.MModel;
import model.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinningNumbersCreator implements ModelCreator<WinningNumbers> {

    @Override
    public WinningNumbers create(Optional<String> input, MModel<?>... models) {
        List<Integer> numbers = Arrays.stream(input.orElseThrow().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new WinningNumbers(numbers);
    }
}
