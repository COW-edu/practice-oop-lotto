package lotto;

import controller.LottoController;
import model.LottoNumber;
import view.LottoView;

public class Application {
    public Application() {

        LottoNumber lottoNumber = new LottoNumber();
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoNumber, lottoView);

        lottoController.run();
    }
    public static void main(String[] args) {
        Application app = new Application();
    }
}
