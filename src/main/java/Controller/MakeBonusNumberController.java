package Controller;

import Model.BonusNum;
import View.InputView;
import View.OutputView;

public class MakeBonusNumberController {
    OutputView outputView = new OutputView();
    public void service(){
        outputView.printBonusNumberMessage();
        String bonusInput = InputView.getInput();
        BonusNum bonusNumber = new BonusNum(bonusInput);
        bonusNumber.validate_Bonus(String.valueOf(bonusInput));
    }
}
