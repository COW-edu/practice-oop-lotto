package controllerManager;

import model.*;
import modelCreator.*;

import java.util.HashMap;
import java.util.Map;

public class ModelCreatorManager {
    private final Map<Class<?>, ModelCreator<?>> creators = new HashMap<>();

    public ModelCreatorManager() {
        creators.put(PurchaseInfo.class, new PurchaseInfoCreator());
        creators.put(PurchasedLottos.class, new PurchasedLottosCreator());
        creators.put(WinningNumbers.class, new WinningNumbersCreator());
        creators.put(BonusNumber.class, new BonusNumberCreator());
        creators.put(WinningResult.class, new WinningResultCreator());
        creators.put(ProfitRate.class, new ProfitRateCreator());
    }

    @SuppressWarnings("unchecked")
    public <T> ModelCreator<T> get(Class<T> modelClass) {
        return (ModelCreator<T>) creators.get(modelClass);
    }
}