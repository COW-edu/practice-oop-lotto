package controllerManager;

import model.BonusNumber;
import model.MModel;
import model.PurchaseInfo;
import model.WinningNumbers;
import validator.BonusNumberValidator;
import validator.PurchaseAmountValidator;
import validator.Validator;
import validator.WinningNumbersValidator;

import java.util.HashMap;
import java.util.Map;

public class ValidatorManager {
    private final Map<Class<?>, Validator> validators = new HashMap<>();

    public ValidatorManager() {
        validators.put(PurchaseInfo.class, new PurchaseAmountValidator());
        validators.put(WinningNumbers.class, new WinningNumbersValidator());
        validators.put(BonusNumber.class, new BonusNumberValidator());
    }

    public void validate(Class<?> targetClass, String value) {
        Validator validator = validators.get(targetClass);
        if (validator != null) {
            validator.validate(value);
        }
    }

    public Validator getValidator(Class<?> modelClass) {
        return validators.get(modelClass);
    }

    public void injectDependency(Class<?> modelClass, MModel<?> model) {
        Validator validator = validators.get(modelClass);
        if (validator instanceof BonusNumberValidator && model instanceof WinningNumbers) {
            ((BonusNumberValidator) validator).setWinningNumbers((WinningNumbers) model);
        }
    }
}
