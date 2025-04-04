package inputController;

import global.MessageManager;
import viewInterface.InputController;

public class PurchaseInfoInputController extends InputController {

    @Override
    public String getMessage() {
        return MessageManager.MessageType.INPUT_LOTTO_PRICE.getMessage();
    }
}
