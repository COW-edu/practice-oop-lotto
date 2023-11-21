package Controller;

import Entity.WinningNum;
import View.InputView;
import View.OutputView;

public class MakeWinningNumbersController implements Controllable{
    OutputView outputView = new OutputView();
    @Override
    public void process(){
        outputView.printLottoNumberMessage();
        String lottoNumsInput = InputView.getInput();
        WinningNum winningNumber = new WinningNum(lottoNumsInput);
        winningNumber.validate_Lotto();
    }
}
