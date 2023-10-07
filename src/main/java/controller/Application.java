package controller;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        FlowController flowController = new FlowController(inputView, outputView);
        flowController.run();
    }
}
