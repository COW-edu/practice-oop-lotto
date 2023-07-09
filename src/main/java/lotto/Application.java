package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.run();
        } catch (IllegalAccessError e) {
            System.out.println(e.getMessage());
        }
    }
}
