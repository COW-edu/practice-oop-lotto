package controllerManager;

import model.*;
import modelCreator.*;

import java.util.HashMap;
import java.util.Map;

public class ModelCreatorManager {
    private final Map<Class<?>, ModelCreator<?>> creators = new HashMap<>();

    public ModelCreatorManager(ValidatorManager validatorManager) {
        creators.put(PurchaseInfo.class, new PurchaseInfoCreator(validatorManager));
        creators.put(PurchasedLottos.class, new PurchasedLottosCreator(validatorManager));
        creators.put(WinningNumbers.class, new WinningNumbersCreator(validatorManager));
        creators.put(BonusNumber.class, new BonusNumberCreator(validatorManager));
        creators.put(WinningResult.class, new WinningResultCreator(validatorManager));
        creators.put(ProfitRate.class, new ProfitRateCreator(validatorManager));
    }

    @SuppressWarnings("unchecked")
    public <T> ModelCreator<T> get(Class<T> modelClass) {
        return (ModelCreator<T>) creators.get(modelClass);
    }
}