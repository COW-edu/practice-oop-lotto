package lotto;

import controller.FrontController;
import domain.Reward;
import domain.Customer;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Customer customer = new Customer();
        OutputView outputView = new OutputView();
        Reward reward = new Reward();

        FrontController frontController = new FrontController(customer, outputView, reward);
        frontController.run();
    }
}
