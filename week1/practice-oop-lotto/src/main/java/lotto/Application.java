package lotto;

import controllerManager.InputControllerManager;
import controllerManager.ModelCreatorManager;
import controllerManager.OutputControllerManager;
import controllerManager.ValidatorManager;
import view.View;

public class Application {
    public static void main(String[] args) {

        ValidatorManager validatorManager = new ValidatorManager();
        InputControllerManager inputManager = new InputControllerManager();
        ModelCreatorManager creatorManager = new ModelCreatorManager(validatorManager);
        OutputControllerManager outputManager = new OutputControllerManager();
        View view = new View();

        MainSystem system = new MainSystem(inputManager, creatorManager, outputManager, view);
        system.run();
    }
}
