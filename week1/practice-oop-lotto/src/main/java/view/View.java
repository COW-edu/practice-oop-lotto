package view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public String inputValue(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public void outputValue(String message) {
        System.out.println(message);
    }
}
