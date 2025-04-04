package controllerManager;

import model.ProfitRate;
import model.PurchaseInfo;
import model.PurchasedLottos;
import model.WinningResult;
import outputController.ProfitRateOutputController;
import outputController.PurchaseCountOutputController;
import outputController.PurchasedLottosOutputController;
import outputController.WinningResultsOutputController;
import viewInterface.OutputController;

import java.util.HashMap;
import java.util.Map;

public class OutputControllerManager {
    private final Map<Class<?>, OutputController> controllers = new HashMap<>();

    public OutputControllerManager() {
        controllers.put(PurchaseInfo.class, new PurchaseCountOutputController());
        controllers.put(PurchasedLottos.class, new PurchasedLottosOutputController());
        controllers.put(WinningResult.class, new WinningResultsOutputController());
        controllers.put(ProfitRate.class, new ProfitRateOutputController());
    }

    public OutputController get(Class<?> modelClass) {
        return controllers.get(modelClass);
    }
}