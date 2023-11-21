package lotto;

import lotto.control.FrontController;

public class Application implements Runnable {

    @Override
    public void run() {
        FrontController frontController = new FrontController();
        frontController.run();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
