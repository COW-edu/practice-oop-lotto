package modelCreator;

import controllerManager.ValidatorManager;
import model.BonusNumber;
import model.MModel;
import model.WinningNumbers;

import java.util.Optional;

public class BonusNumberCreator extends ValidatedModelCreator<BonusNumber> {

    public BonusNumberCreator(ValidatorManager validatorManager) {
        super(validatorManager);
    }

    @Override
    public BonusNumber create(Optional<String> input, MModel<?>... models) {
        if (models.length == 0 || !(models[0] instanceof WinningNumbers)) {
            throw new IllegalArgumentException("WinningNumbers 모델이 필요합니다.");
        }

        WinningNumbers winningNumbers = (WinningNumbers) models[0];

        validatorManager.injectDependency(BonusNumber.class, winningNumbers);

        validatorManager.validate(BonusNumber.class, input.orElse(""));

        int number = Integer.parseInt(input.get());
        return new BonusNumber(number);
    }
}