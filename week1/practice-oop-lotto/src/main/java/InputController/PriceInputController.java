package InputController;

import global.MessageManager;
import viewInterface.InputController;

public class PriceInputController extends InputController {

    @Override
    public String getMessage() {
        return MessageManager.MessageType.INPUT_LOTTO_PRICE.getMessage();
    }
}
