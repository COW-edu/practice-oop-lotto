package InputController;

import global.MessageManager;
import viewInterface.InputController;

public class BonusNumberInputController extends InputController {
    @Override
    public String getMessage() {
        return MessageManager.MessageType.INPUT_BONUS_NUMBER.getMessage();
    }
}
