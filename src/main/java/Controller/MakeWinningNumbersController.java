package Controller;

import Model.WinningNum;
import View.InputView;
import View.OutputView;

public class MakeWinningNumbersController {
    OutputView outputView = new OutputView();
    public void service(){
        outputView.printLottoNumberMessage();
        String lottoNumsInput = InputView.getInput();
        WinningNum winningNumber = new WinningNum(lottoNumsInput);
        winningNumber.validate_Lotto();
    }
}
