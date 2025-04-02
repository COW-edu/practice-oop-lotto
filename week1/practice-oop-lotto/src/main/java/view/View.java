package view;

import camp.nextstep.edu.missionutils.Console;
import viewInterface.InputController;
import viewInterface.OutputController;

public class View {

    public String inputValue(InputController input) {
        System.out.println(input.getMessage());
        return Console.readLine();
    }

    public void outputValue(OutputController output) {
        System.out.println(output.getMessage());
    }
}
