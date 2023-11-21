package lotto;

import controller.CustomerController;
import controller.FrontController;
import controller.LottoController;
import domain.Reward;
import domain.User;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        RandomLotto randomLotto = new RandomLotto();
        OutputView outputView = new OutputView();
        Reward reward = new Reward();
        
        FrontController frontController = new FrontController(user, randomLotto, outputView, reward);
        frontController.run();
    }
}
