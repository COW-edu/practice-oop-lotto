package lotto;

import controller.LottoController;
import model.Lotto;
import model.UserNumber;
import model.WinChecker;
import view.LottoView;

public class Application {
    public Application() {
        UserNumber userNumber = new UserNumber();
        LottoView lottoView = new LottoView();
        Lotto lotto = new Lotto(lottoView.getWinningNumber(), lottoView.getBonusNumber());
        WinChecker winChecker = new WinChecker(userNumber.create(userNumber.buy(lottoView.getMoneyInput())));
        LottoController lottoController = new LottoController(userNumber, lottoView, lotto, );

        lottoController.run();
    }
    public static void main(String[] args) {
        Application app = new Application();
    }
}
