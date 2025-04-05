package inputController;

import global.MessageManager;
import viewController.InputController;

public class BonusNumberInputController extends InputController {
    @Override
    public String getMessage() {
        return MessageManager.MessageType.INPUT_BONUS_NUMBER.getMessage();
    }
}
