package lotto;

import controller.LottoController;
import model.LottoNum;
import model.WinChecker;
import view.LottoView;

public class Application {
    public Application() {
        LottoNum lottoNum = new LottoNum();
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoNum, lottoView);

        lottoController.run();
    }
    public static void main(String[] args) {
        Application app = new Application();
    }
}
