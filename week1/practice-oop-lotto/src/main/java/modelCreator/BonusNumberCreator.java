package modelCreator;

import model.BonusNumber;
import model.MModel;

import java.util.Optional;

public class BonusNumberCreator implements ModelCreator<BonusNumber> {

    @Override
    public BonusNumber create(Optional<String> input, MModel<?>... models) {
        int number = Integer.parseInt(input.orElseThrow());
        return new BonusNumber(number);
    }
}