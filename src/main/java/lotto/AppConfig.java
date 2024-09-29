package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.security.Provider;

public class AppConfig {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    // LottoRepository 인스턴스를 생성하는 메서드
    public LottoRepository lottoRepository() {
        return new LottoRepositoryImpl();
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoRepository());
    }

    public LottoController lottoController() {
        return new LottoController(lottoService(), inputView(), outputView());
    }

}
