package controller;

import view.InputView;
import view.OutputView;

public interface Controller {
    public void service(InputView inputView, OutputView outputView);
}
