package lotto;

import lotto.view.Counter;

public class Application implements Runnable {

    @Override
    public void run() {
        Counter counter = new Counter();
        counter.run();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
