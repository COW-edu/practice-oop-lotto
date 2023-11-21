package Controller;

import Model.BonusNum;
import View.InputView;
import View.OutputView;

public class MakeBonusNumberController implements Controllable{
    OutputView outputView = new OutputView();
    @Override
    public void process(){
        outputView.printBonusNumberMessage();
        String bonusInput = InputView.getInput();
        BonusNum bonusNumber = new BonusNum(bonusInput);
        bonusNumber.validate_Bonus(String.valueOf(bonusInput));
    }
}
