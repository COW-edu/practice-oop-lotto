package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(generator);

        LottoController controller = new LottoController(inputView, outputView, lottoMachine);

        controller.run();
    }
}
