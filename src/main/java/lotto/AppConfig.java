package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(lottoService(), inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private LottoRepository lottoRepository() {
        return new LottoRepositoryImpl();
    }

    private LottoService lottoService() {
        return new LottoServiceImpl(lottoRepository());
    }

}
