package lotto;

import controller.Controller;
import domain.Reward;
import domain.User;
import lotto.RandomLotto;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        User user = new User();
        RandomLotto randomLotto = new RandomLotto();
        OutputView outputView = new OutputView();

        Controller controller = new Controller(user, randomLotto, outputView);
        controller.start();
    }
}
