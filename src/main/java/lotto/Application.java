package lotto;

import controller.Controller;
import user.User;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        User user = new User();
        RandomLotto randomLotto = new RandomLotto();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Controller controller = new Controller(user, randomLotto, inputView, outputView);
        controller.start();
    }
}
