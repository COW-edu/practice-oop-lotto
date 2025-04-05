package modelCreator;

import controllerManager.ValidatorManager;
import model.BonusNumber;
import model.MModel;
import model.PurchaseInfo;
import validator.Validator;

import java.util.Optional;

public class PurchaseInfoCreator extends ValidatedModelCreator<PurchaseInfo> {

    public PurchaseInfoCreator(ValidatorManager validatorManager) {
        super(validatorManager);
    }

    @Override
    public PurchaseInfo create(Optional<String> input, MModel<?>... models) {
        validatorManager.validate(PurchaseInfo.class, input.orElse(""));

        int purchasePrice = Integer.parseInt(input.orElse("0"));
        return new PurchaseInfo(purchasePrice);
    }
}