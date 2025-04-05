package modelCreator;

import controllerManager.ValidatorManager;
import validator.Validator;

import java.util.Optional;

public abstract class ValidatedModelCreator<T> implements ModelCreator<T> {
    protected final ValidatorManager validatorManager;

    protected ValidatedModelCreator(ValidatorManager validatorManager) {
        this.validatorManager = validatorManager;
    }

    protected void validateInput(Optional<String> input, Class<?> modelClass) {
        Validator validator = validatorManager.getValidator(modelClass);
        validator.validate(input.orElseThrow());
    }
}