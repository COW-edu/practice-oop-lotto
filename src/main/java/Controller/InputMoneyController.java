package Controller;

import Model.Money;
import View.InputView;
import View.OutputView;

public class InputMoneyController {
    OutputView outputView = new OutputView();
    public void service(){
        outputView.printMoneyMessage();
        String moneyInput = InputView.getInput();
        Money money = new Money(moneyInput);
        money.validate_Money(moneyInput);


    }
}
