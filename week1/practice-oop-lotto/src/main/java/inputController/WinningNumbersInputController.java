package inputController;

import global.MessageManager;
import viewInterface.InputController;

public class WinningNumbersInputController extends InputController {
    @Override
    public String getMessage() {
        return MessageManager.MessageType.INPUT_WINNING_NUMBERS.getMessage();
    }
}
