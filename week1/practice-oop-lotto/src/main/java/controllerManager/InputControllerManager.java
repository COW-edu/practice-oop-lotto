package controllerManager;

import model.BonusNumber;
import model.PurchaseInfo;
import model.WinningNumbers;
import viewController.InputController;
import inputController.WinningNumbersInputController;
import inputController.PurchaseInfoInputController;
import inputController.BonusNumberInputController;

import java.util.HashMap;
import java.util.Map;

public class InputControllerManager {
    private final Map<Class<?>, InputController> controllers = new HashMap<>();

    public InputControllerManager() {
        controllers.put(PurchaseInfo.class, new PurchaseInfoInputController());
        controllers.put(WinningNumbers.class, new WinningNumbersInputController());
        controllers.put(BonusNumber.class, new BonusNumberInputController());
    }

    public InputController get(Class<?> modelClass) {
        return controllers.get(modelClass);
    }
}
