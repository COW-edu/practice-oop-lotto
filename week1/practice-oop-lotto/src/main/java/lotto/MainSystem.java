package lotto;

import controllerManager.InputControllerManager;
import controllerManager.ModelCreatorManager;
import controllerManager.OutputControllerManager;
import model.*;
import view.View;
import viewController.InputController;
import viewController.OutputController;

import java.util.Optional;


public class MainSystem {

    private final InputControllerManager inputControllerManager;
    private final ModelCreatorManager modelCreatorManager;
    private final OutputControllerManager outputControllerManager;
    private final View view;

    public MainSystem(InputControllerManager inputControllerManager,
                      ModelCreatorManager modelCreatorManager,
                      OutputControllerManager outputControllerManager,
                      View view) {
        this.inputControllerManager = inputControllerManager;
        this.modelCreatorManager = modelCreatorManager;
        this.outputControllerManager = outputControllerManager;
        this.view = view;
    }

    public void run() {
        PurchaseInfo purchaseInfo = createModel(PurchaseInfo.class, Optional.empty());
        outputModel(purchaseInfo);

        PurchasedLottos purchasedLottos = createModel(PurchasedLottos.class, Optional.empty(), purchaseInfo);
        outputModel(purchasedLottos);

        WinningNumbers winningNumbers = createModel(WinningNumbers.class, Optional.empty());
        BonusNumber bonusNumber = createModel(BonusNumber.class, Optional.empty(), winningNumbers);

        WinningResult winningResult = createModel(WinningResult.class, Optional.empty(), purchasedLottos, winningNumbers, bonusNumber);
        outputModel(winningResult);

        ProfitRate profitRate = createModel(ProfitRate.class, Optional.empty(), winningResult, purchaseInfo);
        outputModel(profitRate);
    }

    private <T> T createModel(Class<T> modelClass, Optional<String> input, MModel<?>... models) {
        InputController inputController = inputControllerManager.get(modelClass);
        if (inputController != null && input.isEmpty()) {
            String userInput = view.inputValue(inputController.getMessage());
            input = Optional.of(userInput);
        }

        return modelCreatorManager.get(modelClass).create(input, models);
    }

    private void outputModel(MModel<?> model) {
        OutputController controller = outputControllerManager.get(model.getClass());
        controller.setMessage(model);
        view.outputValue(controller.getMessage());
    }
}
