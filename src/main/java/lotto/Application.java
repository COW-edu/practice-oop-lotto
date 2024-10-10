package lotto;

import controller.LottoControllerImpl;
import view.InputViewImpl;
import view.OutputViewImpl;

public class Application {
    public Application() {
        InputViewImpl inputViewImpl = new InputViewImpl();
        OutputViewImpl outputViewImpl = new OutputViewImpl();
        LottoControllerImpl lottoControllerImpl = new LottoControllerImpl(inputViewImpl, outputViewImpl);

        lottoControllerImpl.run();
    }
    public static void main(String[] args) {
        Application app = new Application();
    }
}
