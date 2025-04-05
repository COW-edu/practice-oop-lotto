package modelCreator;

import controllerManager.ValidatorManager;
import model.BonusNumber;
import model.MModel;
import model.PurchaseInfo;
import model.WinningNumbers;
import validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinningNumbersCreator extends ValidatedModelCreator<WinningNumbers> {

    public WinningNumbersCreator(ValidatorManager validatorManager) {
        super(validatorManager);
    }

    @Override
    public WinningNumbers create(Optional<String> input, MModel<?>... models) {
        validatorManager.validate(WinningNumbers.class, input.orElse(""));

        List<Integer> numbers = Arrays.stream(input.orElseThrow().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new WinningNumbers(numbers);
    }
}
