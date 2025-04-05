package modelCreator;

import controllerManager.ValidatorManager;

public abstract class ValidatedModelCreator<T> implements ModelCreator<T> {
    protected final ValidatorManager validatorManager;

    protected ValidatedModelCreator(ValidatorManager validatorManager) {
        this.validatorManager = validatorManager;
    }
}