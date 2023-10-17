package lotto.view;

import lotto.control.Control;
import lotto.control.Input;
import lotto.control.Output;

public class Counter {

    //Counter 객체
    private final Output output;
    private final Input input;

    public Counter() {
        Control control = new Control();
        this.input = new Input(control);
        this.output = new Output(control);
    }

    public void run() {
        output.askBudget();
        input.inputBudget();
        output.printUserLottoCount();
        output.printLottoList();
        output.askWinLottoNumber();
        input.inputWinningNumber();
        output.askBonusLottoNumber();
        input.inputBonusLottoNumber();
        output.printResult();
        output.printRateOfReturn();
    }

}